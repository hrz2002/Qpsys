package framework.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public final class Utility {
    /**
     * <p>
     * 文字列<code>string</code>を「正規化」した文字列を返す。
     * 「正規化」とは、文字列の前後の空白を取り除き、有効長さ0の文字列を<code>null</code>に置換することをいう。
     * 全角スペースも「空白」として処理される。
     * <ol>
     * <li><code>string</code>が<code>null</code>の場合は、このメソッドは<code>null</code>を返す。</li>
     * <li>そうでない場合、<code>string</code>の前後の空白文字を除去する。
     * 空白文字とは、Javaの正規表現パッケージが提供する&quot;\p{javaWhitespace}&quot;のことを言う。 具体的には<code>string.replaceAll(&quot;(^[\\p{javaWhitespace}]+)|([\\p{Space}　]+$)&quot;, &quot;&quot;)</code>の呼び出しを行う。
     * </li>
     * <li>上記の結果の長さが0より大きければ、このメソッドはその文字列（つまり、前後の空白が取り除かれた<code>string</code>）返す。</li>
     * <li>そうでない場合（長さが0の場合）、このメソッドは<code>null</code>を返す。</li>
     * </ol>
     * </p>
     * <p>
     * <code>{@link #normalizeZenHan(String)}</code>が実施する全角半角の正規化は実施しない。
     * 全角半角統一も含めたシステム標準形式への変換を行う場合は、<code>{@link #canonicalizeInputText(String)}</code>を利用すること。
     * </p>
     *
     * @param string
     *            正規化したい文字列、または<code>null</code>
     * @return 正規化された文字列、または<code>null</code>
     * @throws Exception
     * @see #canonicalizeInputText(String)
     * @see #normalizeZenHan(String)
     */
    static public String normalizeString(final String string) throws Exception {

    	//java.util.Date nowdate=new java.util.Date();
    	//SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd", Locale.CHINA);
    	//Date d = null;
		//try {
//			d = sdf.parse("2016-01-01");
//		} catch (ParseException e) {
//			// TODO 自動生成された catch ブロック
//			e.printStackTrace();
//		}

    	//boolean flag = d.before(nowdate);
    	//if(flag)
    	//System.out.print("早于今天")
    	//else
    	//System.out.print("晚于今天")


    	if (string != null) {
            // You cannot use String#trim(), because Zenkaku spaces shall be
            // removed.
            final String result = string.replaceAll("(^[\\p{javaWhitespace}]+)|([\\p{Space}　]+$)", "");
           // if (flag == false) {
          //  	throw new Exception();
           // }
            if (result.length() > 0) {
                return result;
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

}
