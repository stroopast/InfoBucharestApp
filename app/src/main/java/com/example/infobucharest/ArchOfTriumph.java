package com.example.infobucharest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ArchOfTriumph extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arch_of_triumph);

        TextView archInfo, archMaps;

        archInfo = findViewById(R.id.archTextView);
        archMaps = findViewById(R.id.mapsArch);

        archInfo.setText("The first, wooden, triumphal arch was built hurriedly, after Romania gained its independence (1878), so that the victorious troops could march under it. Another arch with concrete skeleton and plaster exterior of elaborate sculptures and decoration designed by Petre Antonescu was built on the same site after World War I in 1922. The arch exterior, which had seriously decayed, was replaced in 1935 by the current much more sober Neoclassical design, more closely modelled in the Arc de Triomphe in Paris. The new arch, also designed by Petre Antonescu and executed in stone, was inaugurated on 1 December 1936.");
        archMaps.setText(" Show On Maps -> ");

        archMaps.setOnClickListener(View -> archMapsClick());
    }

    public void archMapsClick(){
        Intent intent = new Intent(this, ArchMap.class);
        startActivity(intent);
    }
}