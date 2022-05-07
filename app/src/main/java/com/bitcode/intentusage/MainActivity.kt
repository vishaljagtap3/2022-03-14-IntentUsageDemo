package com.bitcode.intentusage

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.StrictMode
import android.util.Log
import com.bitcode.intentusage.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        StrictMode.setVmPolicy(
            StrictMode.VmPolicy.Builder().build()
        )

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnShowImage.setOnClickListener {
            var intent = Intent("in.bitcode.media.SHOW")
            //intent.action = "in.bitcode.media.SHOW"
            //intent.putExtra("path", binding.edtPath.text.toString())
            intent.setDataAndType(
                Uri.parse(binding.edtPath.text.toString()),
                "image/png"
            )

            startActivity(intent)
        }

        binding.btnShowImageInGal.setOnClickListener {
            var intent = Intent(Intent.ACTION_VIEW)
            intent.setDataAndType(
                Uri.parse(binding.edtPath.text.toString()),
                "image/png"
            )

            startActivity(intent)

        }

        binding.btnPlayAudio.setOnClickListener {
            var intent = Intent(Intent.ACTION_VIEW)
            intent.setDataAndType(
                Uri.parse(binding.edtPath.text.toString()),
                "audio/mp3"
            )

            startActivity(intent)
        }

        binding.btnPlayVideo.setOnClickListener {

            var intent = Intent(Intent.ACTION_VIEW)
            intent.setDataAndType(
                Uri.parse(binding.edtPath.text.toString()),
                "video/mp4"
            )

            startActivity(intent)
        }

        binding.btnOpenWebsite.setOnClickListener {

            var intent = Intent(Intent.ACTION_VIEW)
            intent.setData(
                Uri.parse(binding.edtPath.text.toString())
            )

            startActivity(intent)
        }

        binding.btnShare.setOnClickListener {

            var intent = Intent(Intent.ACTION_SEND)
            intent.setDataAndType(
                Uri.parse(binding.edtPath.text.toString()),
                "image/png"
            )

            startActivity(intent)
        }

        binding.btnCall.setOnClickListener {
            //var intent = Intent(Intent.ACTION_DIAL)
            var intent = Intent(Intent.ACTION_CALL)
            intent.setData(
                Uri.parse(binding.edtPath.text.toString()),
            )

            startActivity(intent)
        }

        binding.btnPickImage.setOnClickListener {
            var intent = Intent(Intent.ACTION_PICK)
            intent.setType("image/*")
            startActivityForResult(
                intent,
                1
            )

        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(data!= null) {
            binding.img.setImageURI(data.data)
            Log.e("tag", data.data.toString())
        }

    }
}