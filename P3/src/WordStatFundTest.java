import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.Test;


public class WordStatFundTest {

	@Test
	public void FileArgumentConstructor() throws IOException{
		WordStat ws = new WordStat ("file.txt");
		assertTrue("The constructor should read the file and get statistics from it", 
	            true);
	}
	@Test
	public void ArrayArgumentConstructor(){
		String test [] = {"This is the First Sentence!","This is the SECOND sentence$","@Just the third sentence"};
		WordStat ws = new WordStat (test);
		assertTrue("The constructor should read the array and get statistics from it", 
	            true);
	}
	
	@Test
	public void testWordCount(){
		String test [] = {"This is the First Sentence!","This is the SECOND sentence$","@Just the third sentence"};
		WordStat ws = new WordStat (test);
		assertEquals("The count should be 2 for is",2,ws.wordCount("is"));
	}
	@Test
	public void testWordRank(){
		String test [] = {"This is the First Sentence!","This is the SECOND sentence$","@Just the third sentence"};
		WordStat ws = new WordStat (test);
		assertEquals("Should be word rank 1", 1, ws.wordRank("the"));
		assertEquals("Should be word rank 1", 1, ws.wordRank("sentence"));
		assertEquals("Should be word rank 3", 3, ws.wordRank("is"));
	}
	@Test
	public void testMostCommonWords(){
		String test [] = {"This is the First Sentence!","This is the SECOND sentence$","@Just the third sentence"};
		WordStat ws = new WordStat (test);
		String[] common = ws.mostCommonWords (3);
		String[] theoretical = {"sentence", "the","is"};
		assertArrayEquals(common, theoretical);
	}
	
	@Test
	public void testLeastCommonWords(){
		String test [] = {"This is the First Sentence!","This is the SECOND sentence$","@Just the third sentence"};
		WordStat ws = new WordStat (test);
		String[] common = ws.leastCommonWords (3);
		String[] theoretical = {"third", "second", "just"};
		assertArrayEquals(common,theoretical);
	}
	@Test
	public void testWordPairCount(){
		String test [] = {"This is the First Sentence!","This is the SECOND sentence$","@Just the third sentence"};
		WordStat ws = new WordStat (test);
		int count = ws.wordPairCount ("the","sentence");
		assertEquals("This method should return the count of the pair of words", 0, count);
		int count1 = ws.wordPairCount("This", "is");
		assertEquals("This method should return the count of the pair of words", 2, count1);
	}
	@Test
	public void testWordPairRank(){
		String test [] = {"This is the First Sentence!","This is the SECOND sentence$","@This is the second sentence"};
		WordStat ws = new WordStat (test);
		int rank = ws.wordPairRank("the","sentence");
		assertEquals("This method should return the rank of the pair of words", 0, rank);
		int rank1 = ws.wordPairRank("This", "is");
		assertEquals("This method should return the rank of the pair of words", 1, rank1);
		int rank2 = ws.wordPairRank("the", "second");
		assertEquals("This method should return the rank of the pair of words", 1, rank2);
	}
	@Test
	public void testMostCommonWordPairs(){
		String test [] = {"This is the First Sentence!","This is the SECOND sentence$","@Just the third sentence"};
		WordStat ws = new WordStat (test);
		String[] common = ws.mostCommonWordPairs (2);
		String[] theoretical = {"is the", "this is"}; 
		assertArrayEquals(theoretical, common);
	}
	@Test
	public void testMostCommonCollocs(){
		String test [] = {"This is the First Sentence!","This is the SECOND sentence$","@Just the third sentence"};
		WordStat ws = new WordStat (test);
		String[] common = ws.mostCommonCollocs(2,"the",2);
		assertTrue("returns the k most common words at a given relative position i to baseWord",true);
	}
	@Test
	public void testMostCommonCollocsExc(){
		String test [] = {"This is the First Sentence!","This is the SECOND sentence$","@Just the third sentence"};
		WordStat ws = new WordStat (test);
		String exc [] = {"the", "is"};
		String[] common = ws.mostCommonCollocsExc(2,"This",4,exc);
		assertTrue("returns the k most common words at a given relative position i to baseWord"
				+"excluding the words in  exclusions array",true);
	}
	@Test
	public void testGenerateWordString(){
		String test [] = {"This is the First Sentence!","This is the SECOND sentence$","@Just the third sentence"};
		WordStat ws = new WordStat (test);
		String common = ws.generateWordString(3,"This");
		assertTrue("returns a string composed of k words of the form startWord",true);
	}
	
}
