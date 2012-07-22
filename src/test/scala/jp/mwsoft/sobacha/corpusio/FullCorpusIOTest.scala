package jp.mwsoft.sobacha.corpusio

import org.scalatest.junit.JUnitRunner
import org.junit.runner.RunWith
import org.scalatest.matchers.ShouldMatchers
import org.scalatest.Spec
import scala.collection.JavaConversions._
import org.scalatest.FunSpec

@RunWith( classOf[JUnitRunner] )
class FullCorpusIOTest extends FunSpec with ShouldMatchers {

  val io = new FullCorpusIO()

  describe( "「もう寝る。」の解析" ) {
    val list = io.readSentence( "もう/副詞/もう 寝る/動詞/ねる 。/補助/。" )
    it( "size 3" ) { list should have length 3 }
    it( "surfaceの確認" ) {
      list.map( _.getSurface() ).toList should be( List( "もう", "寝る", "。" ) )
    }
    it( "featureの確認" ) {
      list.map( _.getTags()( 0 ).getFeature() ).toList should be( List( "副詞", "動詞", "補助" ) )
    }
    it( "pronounceの確認" ) {
      list.map( _.getTags()( 0 ).getPronounce() ).toList should be( List( "もう", "ねる", "。" ) )
    }
  }

  describe( "空行の解析" ) {
    val list = io.readSentence( "" )
    it( "size 0" ) { list should have length 0 }
  }

  describe( "不完全なコーパス" ) {
    it( "Pronounceが足りない場合" ) {
      intercept[InvalidCorpusException] { io.readSentence( "今日/名詞/きょう は/助詞 晴れ/動詞/はれ" ) }
    }
    it( "Featureが空の場合" ) {
      intercept[InvalidCorpusException] { io.readSentence( "今日/名詞/きょう は/助詞/は 晴れ//はれ" ) }
    }
  }

}