package ejercicioslvl3.papersPlease;

import java.util.HashMap;
import java.util.Map;

public class testInspector {


    public static void main(String[] args) {
        Inspector inspector = new Inspector();
        inspector.receiveBulletin("Entrants require passport\nAllow citizens of Arstotzka, Obristan\nCitizens of Antegria, Republia, Obristan require polio vaccination\nWanted by the State: Hubert Popovic\n"
                + "Foreigners require access permit\nDeny citizens of Kolechia, Republia");
        Map<String, String> josef = new HashMap<>();
        josef.put("passport", "ID#: GC07D-FU8AR\nNATION: Arstotzka\nNAME: Costanza, Josef\nDOB: 1933.11.28\nSEX: M\nISS: East Grestin\nEXP: 1983.03.15");
        System.out.println(inspector.inspect(josef));
        
        Map<String, String> roman = new HashMap<>();
        roman.put("passport", "ID#: Y3MNC-TPWQ2\nNATION: Kolechia\nNAME: Dolanski, Roman\nDOB: 1933.01.01\nSEX: M\nISS: Shingleton\nEXP: 1983.05.12");
        roman.put("grant_of_asylum", "NAME: Dolanski, Roman\nNATION: Kolechia\nID#: Y3MNC-TPWQ2\nDOB: 1933.01.01\nHEIGHT: 176cm\nWEIGHT: 71kg\nEXP: 1983.09.20");
        roman.put("access_permit", "NAME: Dolanski, Roman\nNATION: Kolechia\nID#: Y3MNC-TPWQ2\nDOB: 1933.01.01\nHEIGHT: 176cm\nWEIGHT: 71kg\nEXP: 1983.09.20");
        System.out.println(inspector.inspect(roman));

        Map<String, String> guyovich = new HashMap<>();

        guyovich.put("access_permit", "NAME: Guyovich, Russian\nNATION: Obristan\nID#: TE8M1-V3N7R\nPURPOSE: TRANSIT\nDURATION: 14 DAYS\nHEIGHT: 159cm\nWEIGHT: 60kg\nEXP: 1983.07.13");
        System.out.println(inspector.inspect(guyovich));

        String bulletin = "Entrants require passport\n" +
                "Allow citizens of Arstotzka, Obristan";

        Inspector inspector2 = new Inspector();
        inspector2.receiveBulletin(bulletin);

        Map<String, String> entrant1 = new HashMap<>();
        entrant1.put("passport", "ID#: GC07D-FU8AR\n" +
                "NATION: Arstotzka\n" +
                "NAME: Guyovich, Russian\n" +
                "DOB: 1933.11.28\n" +
                "SEX: M\n" +
                "ISS: East Grestin\n" +
                "EXP: 1983.07.10\n"
        );

        System.out.println(inspector2.inspect(entrant1));
    }

}
