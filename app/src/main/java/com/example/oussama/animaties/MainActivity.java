    package com.example.oussama.animaties;

    import android.media.Image;
    import android.support.v7.app.AppCompatActivity;
    import android.os.Bundle;
    import android.view.View;
    import android.widget.ImageView;
    import android.widget.RadioButton;
    import android.widget.SeekBar;

    public class MainActivity extends AppCompatActivity {

        ImageView poImg;
        ImageView shifuImg;
        boolean isPo;
        long duurAnimatie;
        SeekBar seekBar;
        RadioButton fadeRadio , translateRadio, rotateRadio;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            poImg = (ImageView) findViewById(R.id.poImg);
            shifuImg = (ImageView) findViewById(R.id.shifuImg);
            fadeRadio = (RadioButton) findViewById(R.id.fadeRadioButton);
            translateRadio = (RadioButton) findViewById(R.id.translateRadioButton);
            rotateRadio = (RadioButton) findViewById(R.id.rotateRadioButton);

            seekBar = (SeekBar) findViewById(R.id.seekBar);
            seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                    duurAnimatie = progress;
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {

                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {

                }
            });

            isPo = true;
            duurAnimatie = 2000l;

            seekBar.setProgress((int) duurAnimatie);
          //  shifuImg.animate().translationX(-1000).setDuration(0l);
            shifuImg.animate().scaleX(0f).scaleY(0f).setDuration(1l);
        }

        public void animate(View view)
        {
            if(fadeRadio.isChecked())
            {
                fade();
            }

            else if(translateRadio.isChecked())
            {
                rotate();
            }

            else if(rotateRadio.isChecked())
            {
                rotateAndScale();
            }
            isPo = !isPo;
        }

        private void fade()
        {
            if(isPo)
            {
                poImg.animate().alpha(0f).setDuration(2000l);
                shifuImg.animate().alpha(1f).setDuration(2000l);
            }else {
                poImg.animate().alpha(1f).setDuration(2000l);
                shifuImg.animate().alpha(0f).setDuration(2000l);
            }
        }

        private void rotate()
        {
            if(isPo)
            {
                poImg.animate().translationX(1000f).setDuration(duurAnimatie);
                shifuImg.animate().translationX(0f).setDuration(duurAnimatie);
            } else {
                poImg.animate().translationX(0f).setDuration(duurAnimatie);
                shifuImg.animate().translationX(-1000f).setDuration(duurAnimatie);
            }
        }

        private void rotateAndScale()
        {
            if(isPo)
            {
                poImg.animate().rotation(720f).scaleX(0f).scaleY(0f).setDuration(duurAnimatie);
                shifuImg.animate().rotation(-720f).scaleX(1f).scaleY(1f).setDuration(duurAnimatie);
            }else{
                poImg.animate().rotation(-720f).scaleX(1f).scaleY(1f).setDuration(duurAnimatie);
                shifuImg.animate().rotation(720f).scaleX(0f).scaleY(0f).setDuration(duurAnimatie);
            }
        }
    }
