import Service.AdService;
import Service.NavService;
import Service.SystemService;

public class Main {

    public static void main(String[] args) {
        SystemService systemService = SystemService.getInstance();
        AdService adService = AdService.getInstance();
        NavService navService = NavService.getInstance();

        systemService.bootOrFocus();
        System.out.println("Starting ad-loop.");

        while(systemService.isShakesFocused()) {
            for(int i = 0; i < 10; i++) {
                navService.toWheel();
                navService.toTavern();
            }
            adService.openAd();
            adService.wait4Ad();
            adService.closeAd();
        }
    }

}
