package com.qstest.util

import android.widget.Toast

import android.content.Context

import android.content.res.TypedArray
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import androidx.databinding.InverseBindingAdapter
import com.qstest.R


class ProductImageView(context: Context, attrs: AttributeSet) : AppCompatImageView(context,attrs) {

     var imageUrl:String?=null

    init {
        val a: TypedArray = getContext().obtainStyledAttributes(attrs, R.styleable.image_url_text)
        imageUrl= a.getString(R.styleable.image_url_text_image_url)
    }

}
