import java.util.*;

public class Alphabet {
    String UppercaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    String LowercaseLetters = "abcdefghijklmnopqrstuvwxyz";
    String Numbers = "1234567890";
    String Symbols = "!@#$%^&*()-_=+\\/~?";
    String Pool = "";
    int PoolSize;

    public Alphabet(boolean Upper, boolean Lower, boolean Num, boolean Sym) {
        if (Upper) {
            this.Pool = this.Pool + this.UppercaseLetters;
        }

        if (Lower) {
            this.Pool = this.Pool + this.LowercaseLetters;
        }

        if (Num) {
            this.Pool = this.Pool + this.Numbers;
        }

        if (Sym) {
            this.Pool = this.Pool + this.Symbols;
        }

        this.PoolSize = this.Pool.length();
    }

    public String toString() {
        return this.Pool;
    }
}
