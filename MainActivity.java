package com.example.PhoneMic;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;
import android.R;
import android.app.Activity;
import android.media.AudioFormat;
import android.media.AudioRecord;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.util.Log;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.Toast;
public class MainActivity extends Activity {
	TextView text;
public byte[] buffer;
public static DatagramSocket socket;
private int port=50005;
AudioRecord recorder;
private int sampleRate = 44100;// 16000 for music
private int channelConfig = AudioFormat.CHANNEL_IN_MONO;    
private int audioFormat = AudioFormat.ENCODING_PCM_16BIT;       
int minBufSize = AudioRecord.getMinBufferSize(sampleRate, channelConfig, audioFormat);
private boolean status = true;
@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    Switch mySwitch = (Switch) findViewById(R.id.s1);
    text=(TextView) findViewById(R.id.txt);
    text.setText("Slide to talk");
    mySwitch.setChecked(false);
    mySwitch.setOnCheckedChangeListener(new OnCheckedChangeListener(){
		@Override
		 public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {
				
			if(isChecked){
                status = true;
                text.setText("Ready to talk");
                startStreaming();
			}
			else{
				 status = false;
	             recorder.release();
			text.setText("you stopped talking");
			}

		}
    });
}

public void startStreaming() {
    Thread streamThread = new Thread(new Runnable() {
        @Override
        public void run() {
            try {
                DatagramSocket socket = new DatagramSocket();
                byte[] buffer = new byte[minBufSize];
                DatagramPacket packet;
                final InetAddress destination = InetAddress.getByName("192.168.43.86");
                recorder = new AudioRecord(MediaRecorder.AudioSource.MIC,sampleRate,channelConfig,audioFormat,minBufSize*10);
                Log.d("VS", "Recorder initialized");
                recorder.startRecording();                
                while(status == true) {
                    //reading data from MIC into buffer
                    minBufSize = recorder.read(buffer, 0, buffer.length);

                    //putting buffer in the packet
                    packet = new DatagramPacket(buffer,buffer.length,destination,port);
                    socket.send(packet);
                    Toast.makeText(getApplicationContext(), "MinBufferSize: " +minBufSize,Toast.LENGTH_LONG).show();
                }
            } catch(UnknownHostException e) {
                Log.e("VS", "UnknownHostException");
            } catch (IOException e) {
                e.printStackTrace();
                Log.e("VS", "IOException");
            } 
        }

    });
    streamThread.start();
 }
 }
