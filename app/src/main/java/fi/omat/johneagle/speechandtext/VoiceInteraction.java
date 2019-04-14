package fi.omat.johneagle.speechandtext;

import android.widget.TextView;

public class VoiceInteraction {
    private TextView mVoiceInputTv;
    private TTSManager ttsManager = null;
    private boolean VoiceInput = false;

    public VoiceInteraction(TextView mVoiceInputTv, TTSManager ttsManager) {
        this.mVoiceInputTv = mVoiceInputTv;
        this.ttsManager = ttsManager;
    }

    public void process(String input) {
        String successMessage = "Succeed!";

        if (input.toLowerCase().contains("audio online")) {
            VoiceInput = true;
            ttsManager.initQueue(successMessage);
        } else if (input.toLowerCase().contains("audio offline")) {
            VoiceInput = false;
            mVoiceInputTv.setText(successMessage);
        } else {
            String response = input;

            if (VoiceInput) {
                ttsManager.initQueue(response);
            } else {
                mVoiceInputTv.setText(response);
            }
        }
    }
}
