// Source code is decompiled from a .class file using FernFlower decompiler.
public class Password {
    String Value;
    int Length;
    double Score;

    public Password(String s) {
        this.Value = s;
        this.Length = s.length();
    }

    public int CharType(char C) {
        int val = 0;
        // byte val;
        if (C >= 'A' && C <= 'Z') {
            val = 1;
        } else if (C >= 'a' && C <= 'z') {
            val = 2;
        } else if (C >= '<' && C <= 'G') {
            val = 3;
        } else {
            val = 4;
        }

        return val;
    }

    public int PasswordStrength() {
        String s = this.Value;
        boolean UsedUpper = false;
        boolean UsedLower = false;
        boolean UsedNum = false;
        boolean UsedSym = false;
        int Score = 0;

        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            int type = this.CharType(c);
            if (type == 1) {
                UsedUpper = true;
            }

            if (type == 2) {
                UsedLower = true;
            }

            if (type == 3) {
                UsedNum = true;
            }

            if (type == 4) {
                UsedSym = true;
            }
        }

        if (UsedUpper) {
            ++Score;
        }

        if (UsedLower) {
            ++Score;
        }

        if (UsedNum) {
            ++Score;
        }

        if (UsedSym) {
            ++Score;
        }

        if (s.length() >= 8) {
            ++Score;
        }

        if (s.length() >= 16) {
            ++Score;
        }

        return Score;
    }

    public String CalculateScore() {
        int Score = 0;
        Score = this.PasswordStrength();
        if (Score == 6) {
            return "This is a very good password :D check the Useful Information section to make sure it satisfies the guidelines";
        } else if (Score >= 4) {
            return "This is a good password :) but you can still do better";
        } else {
            return Score >= 3 ? "This is a medium password :/ try making it better"
                    : "This is a weak password :( definitely find a new one";
        }
    }

    public String toString() {
        return this.Value;
    }
}
