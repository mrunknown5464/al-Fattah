package com.mrunknown.alfattah.Translator;

import android.content.Context;
import android.widget.Toast;

/*import com.google.cloud.translate.Translate;
import com.google.cloud.translate.TranslateOptions;
import com.google.cloud.translate.Translation;*/

import android.os.Handler;
import java.util.logging.LogRecord;


public class LangTranslate {


    final String ApiKEY="AIzaSyB6x8NaN2TI6dKrV_u2M3HSWOvMqdScHtw";
    Context context;
    String text = "Hello How are you";

    public LangTranslate(Context context) {
/*
        TranslateOptions options=TranslateOptions.newBuilder().setApiKey(ApiKEY).build();
        Translate translate=options.getService();
        final Translation translation=translate.translate(text,Translate.TranslateOption.targetLanguage("ur"));

        Toast.makeText(context, "Translated text : " + translation.getTranslatedText(), Toast.LENGTH_SHORT).show();*/

    }
}
