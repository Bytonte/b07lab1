public class Polynomial {
    double[] coefficients;

    Polynomial() {
        this.coefficients = new double[] {0.0};
    }

    Polynomial(double[] coefficients) {
        if (coefficients == null || coefficients.length == 0) {
            this.coefficients = new double[] {0.0};
        } else {
            this.coefficients = new double[coefficients.length];
            for (int i = 0; i<coefficients.length; i++) {
                this.coefficients[i] = coefficients[i];
            }
        }
    }

    public Polynomial add(Polynomial poly) {
        double[] new_coefficients = new double[Math.max(this.coefficients.length, poly.coefficients.length)];
        for (int i = 0; i<new_coefficients.length; i++) {
            double a,b;
            if (this.coefficients.length-1 < i) {
                a = 0;
            } else {
                a = this.coefficients[i];
            }
            if (poly.coefficients.length-1 < i) {
                b = 0;
            } else {
                b = poly.coefficients[i];
            }
            new_coefficients[i] = a + b;
        }
        return new Polynomial(new_coefficients);
    }
    public double evaluate(double x) {
        double sum = 0.0;
        for (int i = 0; i<this.coefficients.length; i++) {
            sum += this.coefficients[i]*Math.pow(x,i);
        }
        return sum;
    }
    public boolean hasRoot(double x) {
        return this.evaluate(x) == 0;
    }
}