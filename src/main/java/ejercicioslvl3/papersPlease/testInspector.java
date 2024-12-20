package ejercicioslvl3.papersPlease;

import java.util.HashMap;
import java.util.Map;

public class testInspector {


    public static void main(String[] args) {
        Inspector inspector = new Inspector();
        inspector.receiveBulletin("Entrants require passport\\nAllow citizens of Arstotzka, Obristan\\nCitizens of Antegria, Republia, Obristan require polio vaccination\\nWanted by the State: Hubert Popovic\\n"
                + "Foreigners require access permit");
        Map<String, String> josef = new HashMap<>();
        josef.put("passport", "ID#: GC07D-FU8AR\nNATION: Arstotzka\nNAME: Costanza, Josef\nDOB: 1933.11.28\nSEX: M\nISS: East Grestin\nEXP: 1983.03.15");
        System.out.println(inspector.inspect(josef));
        
        Map<String, String> roman = new HashMap<>();
        roman.put("passport", "ID#: WK9XA-LKM0Q\nNATION: United Federation\nNAME: Dolanski, Roman\nDOB: 1933.01.01\nSEX: M\nISS: Shingleton\nEXP: 1983.05.12");
        roman.put("grant_of_asylum", "NAME: Dolanski, Roman\nNATION: United Federation\nID#: Y3MNC-TPWQ2\nDOB: 1933.01.01\nHEIGHT: 176cm\nWEIGHT: 71kg\nEXP: 1983.09.20");
        roman.put("access_permit", "NAME: Dolanski, Roman\nNATION: United Federation\nID#: Y3MNC-TPWQ2\nDOB: 1933.01.01\nHEIGHT: 176cm\nWEIGHT: 71kg\nEXP: 1983.09.20");
        System.out.println(inspector.inspect(roman));

        Map<String, String> guyovich = new HashMap<>();

        guyovich.put("access_permit", "NAME: Guyovich, Russian\nNATION: Obristan\nID#: TE8M1-V3N7R\nPURPOSE: TRANSIT\nDURATION: 14 DAYS\nHEIGHT: 159cm\nWEIGHT: 60kg\nEXP: 1983.07.13");
        System.out.println(inspector.inspect(guyovich));
    }

}
