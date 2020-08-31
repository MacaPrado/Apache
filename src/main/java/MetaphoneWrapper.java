import info.debatty.java.stringsimilarity.NormalizedLevenshtein;
import org.apache.commons.codec.language.Metaphone;

public class MetaphoneWrapper {

    private String str;

    public MetaphoneWrapper(String str) {
        this.str=str;
    }

    public String metaphone(){
        return new Metaphone().encode(str);
    }

    public double metaphoneSimilarity(String other){
        String aux = new MetaphoneWrapper(other).metaphone();
        return new LevenshteinWrapper(metaphone()).normalizedSimilarity(aux);
    }
}
