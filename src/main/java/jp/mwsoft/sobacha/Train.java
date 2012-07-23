package jp.mwsoft.sobacha;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import jp.mwsoft.sobacha.corpusio.CorpusIO;
import jp.mwsoft.sobacha.corpusio.InvalidCorpusException;
import jp.mwsoft.sobacha.tag.Word;

public class Train {

	public static void main(String[] args) {
		Conf conf = new Conf();
	}

	private static void createTrainFile(File corpus, Conf conf) throws IOException, InvalidCorpusException {

		CorpusIO io = CorpusIO.getInstance(conf);

		try (BufferedReader reader = new BufferedReader(new FileReader(corpus))) {
			String line;
			while ((line = reader.readLine()) != null) {
				List<Word> words = io.readSentence(line);
				
			}
		}

	}

}
