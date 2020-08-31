import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.language.Soundex;
import org.apache.commons.text.similarity.LevenshteinDetailedDistance;
import org.apache.commons.text.similarity.LevenshteinDistance;

public class ApacheTester {

    public static void main(String[] args) throws EncoderException {
        System.out.println("Soundex");
        System.out.println(new Soundex().soundex("Brooklin"));
        System.out.println(new SoundexWrapper("Brooklin").distance("Bluclean"));

        System.out.println("Metaphone");
        MetaphoneWrapper enc1 = new MetaphoneWrapper("brooklyn");
        MetaphoneWrapper enc2 = new MetaphoneWrapper("clean");
        System.out.println(enc1.metaphone());
        System.out.println(enc2.metaphone());

        System.out.println("METAPHONE SIMILARITY");
        System.out.println(enc1.metaphoneSimilarity("clean"));

        System.out.println("Levenshtein");
        int leven = new LevenshteinWrapper("excusa").distance("ex-amigo");
        System.out.println(leven);
        double distance = new LevenshteinWrapper("excusa").normalizedSimilarity("ex-amigo");
        System.out.println(distance);

        System.out.println("QGram");
        System.out.println(new QGramWrapper(2).distance("salesal", "alale"));
        System.out.println(new QGramWrapper(2).printTokens("alal"));

    }
}
