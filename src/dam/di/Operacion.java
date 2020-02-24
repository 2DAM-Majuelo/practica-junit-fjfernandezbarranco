package dam.di;

import java.util.Objects;

public class Operacion {
    private int opr1;
    private int opr2;
    private char tipo_opr;

    /**
     * Crea una instancia de operación para realizar un cálculo.
     * @param opr1 Primer operando.
     * @param opr2 Segundo operando.
     * @param tipo_opr Operación a ralizar: (+ --> Suma, - --> Resta, * --> Producto,
     *                 / --> división entera, m --> media)
     */
    public Operacion(int opr1, int opr2, char tipo_opr) {
        this.opr1 = opr1;
        this.opr2 = opr2;
        this.tipo_opr = tipo_opr;
    }

    /**
     * Ejecuta la operación en un tiempo inferior a 30 ms
     * @return El resultado de la operación como un número entero (sin redondeo).
     * @throws IllegalArgumentException Si la operación indicada es desconocida o incorrecta.
     */
    public int getIntResult(){
        switch (tipo_opr){
            case '+':
                return opr1 + opr2;
            case '-':
                return opr1 - opr2;
            case '*':
                return opr1 * opr2;
            case '/':
                return opr1 / opr2;
            case 'm':
                return (opr1 + opr2)/2;
            default:
                throw new IllegalArgumentException("Operación desconocida");
        }
    }

    /**
     * Ejecuta la operación en un tiempo inferior a 60 ms
     * @return El resultado de la operación como un número en punto flotante.
     * @throws IllegalArgumentException Si la operación indicada es desconocida o incorrecta.
     */
    public double getRealResult(){
        switch (tipo_opr){
            case '+':
                return (double) opr1 + opr2;
            case '-':
                return (double) opr1 - opr2;
            case '*':
                return (double) opr1 * opr2;
            case '/':
                return ((double) opr1) / opr2;
            case 'm':
                return ((double) opr1 + opr2)/2;
            default:
                throw new IllegalArgumentException("Operación desconocida");
        }
    }

    /**
     * Crea un objeto diferente con los mismos datos del original
     * @return Una copia de este objeto.
     */
    @Override
    protected Object clone() {
        return new Operacion(this.opr1, this.opr2, this.tipo_opr);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Operacion operacion = (Operacion) o;
        return opr1 == operacion.opr1 &&
                opr2 == operacion.opr2 &&
                tipo_opr == operacion.tipo_opr;
    }

    @Override
    public int hashCode() {
        return Objects.hash(opr1, opr2, tipo_opr);
    }
}
