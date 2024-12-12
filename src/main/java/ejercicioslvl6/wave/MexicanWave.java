package ejercicioslvl6.wave;

public class MexicanWave {


    public static String[] wave(String str) {
        int waveCount = 0;
        for (char c : str.toCharArray()) {
            if (c != ' ') {
                waveCount++;
            }
        }
        String[] waves = new String[waveCount];

        int index = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ' ') {
                char[] chars = str.toCharArray();
                chars[i] = Character.toUpperCase(chars[i]);

                waves[index++] = new String(chars);
            }
        }
        return waves;
    }

}
