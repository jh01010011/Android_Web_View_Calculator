package randomforest.com.webviewcal;

import android.content.Context;
import android.util.Log;
import android.webkit.JavascriptInterface;

import bsh.EvalError;
import bsh.Interpreter;

/**
 * Created by blueb on 5/5/2017.
 */

public class ScriptInterface {

    Context mContext;


    public ScriptInterface(Context context){
        mContext=context;

    }
    @JavascriptInterface
    public String result(String string){
        String str = "result =";
        str = str + string;
        char t=str.charAt(str.length()-1);
        if(t == '/' || t == '*' || t == '+' || t == '-' || t == '.' ){
            return "Syntax error!!!";

        }
        else {

            try {
                Interpreter interpreter = new Interpreter();
                interpreter.eval(str);
                return  interpreter.get("result").toString();

            } catch (EvalError ignored) {
                return "Evaluation error";
            }
            }


     //return "";
    }

    @JavascriptInterface
    public void test(){
        Log.v("Interface","Plus clicked");
    }


}
