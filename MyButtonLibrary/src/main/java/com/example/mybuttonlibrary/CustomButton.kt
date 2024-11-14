package com.example.mybuttonlibrary

import android.content.Context
import android.content.res.ColorStateList
import android.util.AttributeSet
import android.util.TypedValue
import com.google.android.material.button.MaterialButton

fun Context.dpToPx(dp: Float): Int {
    return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, resources.displayMetrics).toInt()
}

class CustomMaterialButton @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : MaterialButton(context, attrs, defStyleAttr) {

    init {
        // Personalizar el botón

        // Usamos ColorStateList para definir los colores
        val backgroundColor = context.getColor(android.R.color.holo_blue_light) // Un color simple
        val rippleColor = context.getColor(android.R.color.holo_green_light) // Otro color simple

        // Configuramos el tint de fondo usando setBackgroundTintList()
        this.backgroundTintList = ColorStateList.valueOf(backgroundColor)

        // Configuramos el tint del ripple (efecto de clic) usando setRippleColor()
        this.rippleColor = ColorStateList.valueOf(rippleColor)

        // Convertimos dp a px para cornerRadius
        val cornerRadiusInDp = 16f // Usamos un valor en dp
        cornerRadius = context.dpToPx(cornerRadiusInDp) // Convertimos el resultado a Int

        // Otros atributos
        setTextColor(context.getColor(android.R.color.white))
    }
}
