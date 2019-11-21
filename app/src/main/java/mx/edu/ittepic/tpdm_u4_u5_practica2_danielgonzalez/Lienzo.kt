package mx.edu.ittepic.tpdm_u4_u5_practica2_danielgonzalez

import android.graphics.Canvas
import android.graphics.Paint
import android.view.MotionEvent
import android.view.View
import android.widget.Toast
import java.util.ArrayList

class Lienzo(p:MainActivity): View(p) {
    var puntero = p

    var icono1 = Imagen(this, 50f, 250f, R.drawable.facebook)
    var icono2 = Imagen(this, 200f, 250f, R.drawable.instagram)
    var icono3 = Imagen(this, 350f, 250f, R.drawable.twitter)
    var icono4 = Imagen(this, 500f, 250f, R.drawable.whatsapp)
    var icono5 = Imagen(this, 650f, 250f, R.drawable.youtube)

    var icono1_black = Imagen(this, 50f, 250f, R.drawable.facebookblack)
    var icono2_black = Imagen(this, 188f, 250f, R.drawable.instagramblack)
    var icono3_black = Imagen(this, 326f, 250f, R.drawable.twitterblack)
    var icono4_black = Imagen(this, 454f, 250f, R.drawable.whatsappblack)
    var icono5_black = Imagen(this, 592f, 250f, R.drawable.youtubeblack)

   var icono1_vintage = Imagen(this, 50f, 250f, R.drawable.facebookvintage)
    var icono2_vintage = Imagen(this, 188f, 250f, R.drawable.instagramvintage)
    var icono3_vintage = Imagen(this, 326f, 250f, R.drawable.twittervintage)
    var icono4_vintage = Imagen(this, 454f, 250f, R.drawable.whatsappvintage)
    var icono5_vintage = Imagen(this, 592f, 250f, R.drawable.youtubevintage)

   var icono1_2 = Imagen(this, 50f, 250f, R.drawable.facebook)
    var icono2_2 = Imagen(this, 188f, 250f, R.drawable.instagram)
    var icono3_2 = Imagen(this, 326f, 250f, R.drawable.twitter)
    var icono4_2 = Imagen(this, 454f, 250f, R.drawable.whatsapp)
    var icono5_2 = Imagen(this, 592f, 250f, R.drawable.youtube)

    var arrayImg = arrayListOf<Imagen>(icono1,icono2,icono3,icono4,icono5)
    var arrayImg2 = arrayListOf<Imagen>(icono1_black,icono2_black,icono3_black,icono4_black,icono5_black)
    var arrayImg3 = arrayListOf<Imagen>(icono1_vintage,icono2_vintage,icono3_vintage,icono4_vintage,icono5_vintage)
    var arrayImg4 = arrayListOf<Imagen>(icono1_2,icono2_2,icono3_2,icono4_2,icono5_2)
    var picono: Imagen ?= null

    override fun onDraw(c: Canvas) {
        super.onDraw(c)
        var p = Paint()

        if(puntero.distancia == 0f){
            Toast.makeText(puntero,"Oculto", Toast.LENGTH_SHORT).show()
        }
        else{
            when (puntero.countShake) {
                0 -> {
                    drawImgs(arrayImg, c)
                    moverImagenes(arrayImg, puntero.x)
                }
                1 -> {
                    drawImgs(arrayImg2, c)
                    moverImagenes(arrayImg2, puntero.x)
                }
                2 -> {
                    drawImgs(arrayImg3, c)
                    moverImagenes(arrayImg3, puntero.x)
                }
                3 -> {
                    drawImgs(arrayImg4, c)
                    moverImagenes(arrayImg4, puntero.x)
                }
            }

        }

    }

    override fun onTouchEvent(e: MotionEvent): Boolean {
        when(e.action){

            MotionEvent.ACTION_DOWN -> {
                if(icono1.estaEnArea(e.getX(),e.getY())||
                    icono1_black.estaEnArea(e.getX(),e.getY())||
                    icono1_vintage.estaEnArea(e.getX(),e.getY())||
                    icono1_2.estaEnArea(e.getX(),e.getY())
                ){
                    Toast.makeText(puntero,"Tocaste icono Facebook", Toast.LENGTH_SHORT)
                        .show()
                    picono = icono1

                }
                if(icono2.estaEnArea(e.getX(),e.getY())||
                    icono2_black.estaEnArea(e.getX(),e.getY())||
                    icono2_vintage.estaEnArea(e.getX(),e.getY())||
                    icono2_2.estaEnArea(e.getX(),e.getY())
                ){
                    Toast.makeText(puntero,"Tocaste icono Instagram", Toast.LENGTH_SHORT)
                        .show()
                    picono = icono2
                }
                if(icono3.estaEnArea(e.getX(),e.getY())||
                    icono3_black.estaEnArea(e.getX(),e.getY())||
                    icono3_vintage.estaEnArea(e.getX(),e.getY())||
                    icono3_2.estaEnArea(e.getX(),e.getY())
                ){
                    Toast.makeText(puntero,"Tocaste icono Twitter", Toast.LENGTH_SHORT)
                        .show()
                    picono = icono3
                }
                if(icono4.estaEnArea(e.getX(),e.getY())||
                    icono4_black.estaEnArea(e.getX(),e.getY())||
                    icono4_vintage.estaEnArea(e.getX(),e.getY())||
                    icono4_2.estaEnArea(e.getX(),e.getY())
                ){
                    Toast.makeText(puntero,"Tocaste icono Whatsapp", Toast.LENGTH_SHORT)
                        .show()
                    picono = icono4
                }
                if(icono5.estaEnArea(e.getX(),e.getY())||
                    icono5_black.estaEnArea(e.getX(),e.getY())||
                    icono5_vintage.estaEnArea(e.getX(),e.getY())||
                    icono5_2.estaEnArea(e.getX(),e.getY())
                ){
                    Toast.makeText(puntero,"Tocaste icono YouTube", Toast.LENGTH_SHORT)
                        .show()
                    picono = icono5
                }
            }
            MotionEvent.ACTION_MOVE -> {

            }
            MotionEvent.ACTION_UP -> {
                picono = null
            }

        }
        return true
    }

    fun moverImagenes(arrayImagenes: ArrayList<Imagen>, x:Float){
        arrayImagenes.forEach {
            it.mover(x)
        }
        invalidate()
    }


    fun drawImgs(arrayImagenes: ArrayList<Imagen>, c: Canvas) {
        arrayImagenes.forEach {
            it.pintar(c)

        }
    }
}
