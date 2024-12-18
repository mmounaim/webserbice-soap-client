package enset.mounaim;

import Proxy.BanqueService;
import Proxy.BanqueWebService;
import Proxy.Compte;

import java.util.List;

public class Client {
    public static void main(String[] args) {
        BanqueService banqueService = new BanqueWebService().getBanqueServicePort();
        System.out.println("================Conversion Euro To Dh=======");
        System.out.println(banqueService.conversionEuroToDh(1000));

        System.out.println("================Compte=======");
        Compte compte = banqueService.getCompte(1);
        System.out.println("Le code: "+ compte.getCode());
        System.out.println("Le solde: " + compte.getSolde());
        System.out.println("La date creation: "+ compte.getCreationDate());


        System.out.println("================List Comptes=======");
        List<Compte> compteList = banqueService.listComptes();
        compteList.forEach(c-> {
            System.out.println("Le code: "+ c.getCode());
            System.out.println("Le solde: " + c.getSolde());
            System.out.println("La date creation: "+ c.getCreationDate());
        });
    }
}
