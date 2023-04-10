package com.example.mydrawing

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class MainActivity : AppCompatActivity() {
    private var drawingView:DrawingView?=null
//    lateinit var
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
         drawingView=findViewById(R.id.drawing_view)
        drawingView?.setSizeForBrush(20.toFloat()) //we see slightly thicker because it will
        //now consider the size of the screen smaller the screen more thicker
        val ib_brush=findViewById<ImageButton>(R.id.ib_brush)
        ib_brush.setOnClickListener{
            showBrushSizeChooserDialog()
        }

    }
    private fun showBrushSizeChooserDialog(){
        val brushDialog=Dialog(this)
        brushDialog.setContentView(R.layout.dialog_brush_size)
        brushDialog.setTitle("Choose Brush Size !!")
        val small_btn=brushDialog.findViewById<ImageButton>(R.id.myImageButton_small)
        small_btn.setOnClickListener{
            drawingView?.setSizeForBrush(10.toFloat())
            brushDialog.dismiss()
        }
        val medium_btn=brushDialog.findViewById<ImageButton>(R.id.myImageButton_medium)
        medium_btn.setOnClickListener {
            drawingView?.setSizeForBrush(20.toFloat())
            brushDialog.dismiss()
        }
        val large_btn=brushDialog.findViewById<ImageButton>(R.id.myImageButton_large)
        large_btn.setOnClickListener {
            drawingView?.setSizeForBrush(30.toFloat())
            brushDialog.dismiss()
        }
        brushDialog.show()
    }
}