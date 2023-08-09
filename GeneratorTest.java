
// Source code is decompiled from a .class file using FernFlower decompiler.
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GeneratorTest {
    Password P1 = new Password("Secret");
    Alphabet A1 = new Alphabet(true, false, false, false);
    Alphabet A2 = new Alphabet(false, true, true, true);
    Generator G1 = new Generator(true, false, false, false);
    Password P2;

    GeneratorTest() {
        this.P2 = this.G1.GeneratePassword(4);
    }

    @Test
    void test1() {
        Assertions.assertEquals("Secret", this.P1.toString());
    }

    @Test
    void test2() {
        Assertions.assertEquals(this.A1.Pool, this.A1.UppercaseLetters);
    }

    @Test
    void test3() {
        Assertions.assertEquals(this.A2.Pool, this.A2.LowercaseLetters + this.A2.Numbers + this.A2.Symbols);
    }

    @Test
    void test4() {
        Assertions.assertEquals(this.G1.Alphabet.Pool, this.A1.UppercaseLetters);
    }

    @Test
    void test5() {
        Assertions.assertEquals(this.G1.Alphabet.PoolSize, 26);
    }

    @Test
    void test6() {
        Assertions.assertEquals(this.P2.Length, 4);
        System.out.println(this.P2);
    }
}
