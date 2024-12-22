package ejercicioslvl2.mathematical;

public class MathEvaluator {

    public double calculate(String expression) {
        String nuevaExpresion = expression.replaceAll(" ", "");
        System.out.println(nuevaExpresion);
        if (nuevaExpresion.contains("(")){
            String substring = nuevaExpresion.substring(nuevaExpresion.indexOf("(") + 1, nuevaExpresion.indexOf(")"));
            String subParen = nuevaExpresion.substring(nuevaExpresion.indexOf("("), nuevaExpresion.indexOf(")") + 1);
            System.out.println(substring);
            double resultadoParentesis = hacerOperacion(substring);
            nuevaExpresion = nuevaExpresion.replace(subParen, resultadoParentesis+"");
            System.out.println(nuevaExpresion);

        }

        return 0.0;
    }

    private double hacerOperacion(String operacion) {
        String [] partes = operacion.split("");
        double resultado = Double.parseDouble(partes[0]) + Double.parseDouble(partes[2]);
        System.out.println(resultado);
        return resultado;
    }

}












class calc{

    public static void main(String[] args) {
        MathEvaluator mates = new MathEvaluator();
        double que = mates.calculate("2 - (1+3)");
    }
}