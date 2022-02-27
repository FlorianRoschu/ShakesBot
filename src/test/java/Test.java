import Service.AdService;
import Service.NavService;
import Service.OcrService;
import Service.SystemService;
import Enum.State;

import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.Mockito.*;

import org.junit.jupiter.*;


@RunWith(MockitoJUnitRunner.class)
public class Test {

    public static void main(String[] args) {
        AdService adService = AdService.getInstance();
        NavService navService = NavService.getInstance();
        SystemService systemService = SystemService.getInstance();
        OcrService ocrService = OcrService.getInstance();

        System.out.println(ocrService.isInExpectedState(State.AD_ONGOING));
    }

}
