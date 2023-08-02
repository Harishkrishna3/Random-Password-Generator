import java.util.*;
class randomPasswordGenerator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("ENTER THE LENGTH ");
        int length = sc.nextInt();
        passwordGenerator ob = new passwordGenerator(); 
        Set<String> passwords = ob.randomPassword(length); 
        System.out.println("Generated passwords:");
        int i = 1;
        for (String password : passwords) {
            System.out.println("RECOMMENDED PASSWORD " + i + "--> " + password);
	    System.out.println();
            i++;
        }
        System.out.println("THANK YOU FOR USING OUR PASSWORD GENERATOR!");
    }
}
class passwordGenerator {
    Random rand = new Random();

    Set<String> randomPassword(int length) {
        int n = (int) Math.ceil(length / 4.0);
        int scr = (int) Math.ceil(length / 6.0);
        int uc = (int) Math.ceil(length / 4.0);
        int lc = length - n - scr - uc;
        Set<String> passwords = new HashSet<>();

        for (int i = 0; i < 5; i++) {
            String a = number(n);
            String b = specialCharacter(scr);
            String c = upperChar(uc);
            String d = lowerChar(lc);
            String passwordGenerated = a + b + c + d;
            passwords.add(passwordGenerated);
        }

        suffles su = new suffles();
        Set<String> shuffledPasswords = new HashSet<>();
        for (String password : passwords) {
            String newPassword = su.stringShuffle(password);
            shuffledPasswords.add(newPassword);
        }
        return shuffledPasswords;
    }

    String specialCharacter(int scr) {
        String spl = "+/-.!@#$%^&*_=,?`~";
        List<Character> password = new ArrayList<>();
        for (int i = 0; i < scr; i++) {
            password.add(spl.charAt(rand.nextInt(spl.length())));
        }
        return charListToString(password);
    }

    String number(int n) {
        List<Character> nu = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            nu.add(nums(i));
        }
        return charListToString(nu);
    }

    char nums(int i) {
        int rando = rand.nextInt(9);
        return (char) (rando + '0');
    }

    String upperChar(int uc) {
        List<Character> pas = new ArrayList<>();
        for (int i = 0; i < uc; i++) {
            pas.add(vin(i));
        }
        return charListToString(pas);
    }

    char vin(int i) {
        int rando = rand.nextInt(26) + 65;
        return (char) rando;
    }

    String lowerChar(int lc) {
        List<Character> pas = new ArrayList<>();
        for (int i = 0; i < lc; i++) {
            pas.add(vini(i));
        }
        return charListToString(pas);
    }

    char vini(int i) {
        int rando = rand.nextInt(26) + 97;
        return (char) rando;
    }

    String charListToString(List<Character> charList) {
        StringBuilder sb = new StringBuilder(charList.size());
        for (Character ch : charList) {
            sb.append(ch);
        }
        return sb.toString();
    }
}

class suffles {
    String stringShuffle(String inputString) {
        List<Character> chars = new ArrayList<>();
        for (char ch : inputString.toCharArray()) {
            chars.add(ch);
        }

        Collections.shuffle(chars);

        return charListToString(chars);
    }

    String charListToString(List<Character> charList) {
        StringBuilder sb = new StringBuilder(charList.size());
        for (Character ch : charList) {
            sb.append(ch);
        }
        return sb.toString();
    }
}