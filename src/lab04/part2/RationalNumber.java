package lab04.part2;

public class RationalNumber {
    
    private int num;  // Numerator
    private int den;  // Denominator
    
    
    //---------------------
    //  Constructors
    //---------------------
    public RationalNumber() {
        this.setNum(1);
        this.setDen(1);
    }

    public RationalNumber(int num, int den) {
        // Validation could be added to check that Denominator != 0
        this.setNum(num);
        this.setDen(den);
    }
    
    //---------------------
    //  Getters, Setters, toString
    //---------------------
    public void setNum(int num) { this.num = num; }
    public int  getNum() { return this.num; }
    public void setDen(int den) { this.den = den; }
    public int  getDen() { return this.den; }
    
    public String toString() {
        return this.getNum() + "/" + this.getDen() 
        + " (" + (double) this.getNum()/ (double) this.getDen() + ")";
    }
    
    //---------------------
    //  Methods - Arithmetic operations
    //---------------------
    public RationalNumber add(RationalNumber b) {
        return new RationalNumber(
            this.getNum() * b.getDen() + b.getNum() * this.getDen(),
            this.getDen() * b.getDen()
        );
    }
    
    public RationalNumber sub(RationalNumber b) {
        RationalNumber minusb = new RationalNumber(b.getNum() * -1, b.getDen());
        return this.add(minusb);
    }

    public RationalNumber mult(RationalNumber b) {
        return new RationalNumber(
            this.getNum() * b.getNum(),
            this.getDen() * b.getDen()
        );
    }
    
    public RationalNumber div(RationalNumber b) {
        return new RationalNumber(
            this.getNum() * b.getDen(),
            this.getDen() * b.getNum()
        );
    }
    
    public Boolean equals(RationalNumber b) {
        return this.getNum() == b.getNum() 
            && this.getDen() == b.getDen();
    }
}

