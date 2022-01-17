package mockedunicorns;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import mockedunicorns.model.Unicorn;
import mockedunicorns.model.UnicornAlreadyPairedException;
import mockedunicorns.model.UnicornException;

import java.io.*;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.powermock.api.mockito.PowerMockito.*;

//import static org.mockito.Mockito.*;

@RunWith(PowerMockRunner.class)
public class UnicornsManagerTest {

    UnicornsManager manager;
    Unicorn unicorn1, unicorn2, unicorn3, unicorn4;

    @Rule
    public ExpectedException exceptionGrabber = ExpectedException.none();

    @Before
    public void prepare() {
        manager = new UnicornsManager();
        unicorn1 = new Unicorn("RainbowDash");
        unicorn2 = new Unicorn("ShiningArmor");
        unicorn3 = new Unicorn("RainbowDash");
        unicorn4 = new Unicorn("ShiningArmor");
    }

    @Test
    public void UnicornWhenCreated() {
        assertNotNull("collection should exist", manager.getUnicorns());
        assertThat("Collection should be empty", manager.getUnicorns().isEmpty(), is(true));
    }

    @Test
    public void addWhenParamProvided() {
        manager.add(unicorn1);
        assertThat(manager.getUnicorns().size(), is(1));
        assertThat(manager.getUnicorns(), hasItem(unicorn1));
    }

    @Test
    public void pairWhenTwoDifferentUnicorns() throws UnicornAlreadyPairedException {
        manager.add(unicorn1);
        manager.add(unicorn2);
        manager.pair(unicorn1, unicorn2);

        assertEquals(unicorn2, manager.getPaired(unicorn1));
        assertEquals(unicorn1, manager.getPaired(unicorn2));
    }

    @Test
    public void getPairedWhenDifferentReferences() throws UnicornAlreadyPairedException{
        manager.add(unicorn1);
        manager.add(unicorn2);
        manager.pair(unicorn1, unicorn2);

        assertEquals(unicorn2, manager.getPaired(unicorn3));
        assertEquals(unicorn1, manager.getPaired(unicorn4));
    }

    @Test
    public void pairWhenPairingNotAddedUnicorns() throws UnicornAlreadyPairedException{
        manager.pair(unicorn1, unicorn2);

        assertNull(manager.getPaired(unicorn1));
        assertNull(manager.getPaired(unicorn2));
    }

    @Test
    public void pairWhenPairAlreadyPairedUnicorns() throws UnicornAlreadyPairedException {
        manager.add(unicorn1);
        manager.add(unicorn2);
        manager.pair(unicorn1, unicorn2);
        exceptionGrabber.expect(UnicornAlreadyPairedException.class);
        exceptionGrabber.expectMessage("At least one of the unicorns already paired.");
        manager.pair(unicorn1, unicorn2);
    }

    @Test
    public void loadWhenFileDoesNotExist() throws UnicornException {
        File input = mock(File.class);
        when(input.exists()).thenReturn(false);

        exceptionGrabber.expect(UnicornException.class);
        exceptionGrabber.expectCause(instanceOf(FileNotFoundException.class));
        manager.load(input);
    }

    @Test
    public void loadWhenFileIsDirectory() throws UnicornException {
        File input = mock(File.class);
        when(input.exists()).thenReturn(true);
        when(input.isDirectory()).thenReturn(true);

        exceptionGrabber.expect(UnicornException.class);
        exceptionGrabber.expectCause(instanceOf(IOException.class));
        manager.load(input);
    }

    @Test
    public void loadWhenFileCannotRead() throws UnicornException {
        File input = mock(File.class);
        when(input.exists()).thenReturn(true);
        when(input.isDirectory()).thenReturn(false);
        when(input.canRead()).thenReturn(false);

        exceptionGrabber.expect(UnicornException.class);
        exceptionGrabber.expectCause(instanceOf(IOException.class));
        manager.load(input);
    }

    @Test
    @PrepareForTest(UnicornsManager.class)
    public void loadWhenOneUnicornInFileNoSpace() throws UnicornException, IOException, Exception {
        File input = mock(File.class);
        when(input.exists()).thenReturn(true);
        when(input.isDirectory()).thenReturn(false);
        when(input.canRead()).thenReturn(true);

        FileReader fr = mock(FileReader.class);
        BufferedReader br = mock(BufferedReader.class);
        when(br.readLine()).thenReturn("RainbowDash").thenReturn(null);

        whenNew(FileReader.class).withArguments(input).thenReturn(fr);
        whenNew(BufferedReader.class).withArguments(fr).thenReturn(br);

        manager.load(input);

        Unicorn unicorn = new Unicorn("RainbowDash");
        assertThat(manager.getUnicorns(), hasItem(unicorn));
    }
}
