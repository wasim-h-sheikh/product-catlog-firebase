package com.qstest.util

import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.databinding.BindingAdapter
import androidx.databinding.InverseBindingAdapter
import androidx.databinding.InverseBindingListener
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.facebook.shimmer.ShimmerFrameLayout
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.qstest.R

class LoadImageBindingAdapter {
    companion object {
        @JvmStatic
        @BindingAdapter(value = ["image_urlAttrChanged","shimmerViewContainer","product_id","parent_node", "error"], requireAll = false)
        fun loadImage(view: ProductImageView,listener: InverseBindingListener,shimmerViewContainer: ShimmerFrameLayout?,
                      productId: String?, parentNode: String?, error: Int) {

            if (!productId.isNullOrEmpty()&&!parentNode.isNullOrEmpty()) {
                shimmerViewContainer?.visibility= View.VISIBLE
                shimmerViewContainer?.startShimmer()
                val database = Firebase.database.reference
                val valueListener = object : ValueEventListener {
                    override fun onDataChange(dataSnapshot: DataSnapshot) {
                        shimmerViewContainer?.visibility= View.GONE
                        shimmerViewContainer?.stopShimmer()
                        val value = dataSnapshot.value as String
                        view.imageUrl=value
                        listener.onChange()
                        displayImage(view,value)
                    }

                    override fun onCancelled(databaseError: DatabaseError) {
                        // Getting Post failed, log a message
                        Log.v(
                            "ProductBindingAdapter",
                            "loadPost:onCancelled",
                            databaseError.toException()
                        )
                    }
                }
                database.child(parentNode).child(productId).addValueEventListener(valueListener)

            }


        }
        @BindingAdapter(value = ["image_url"])
        @JvmStatic fun setImageUrl(view: ProductImageView,imageUrl:String?){
            if (view.imageUrl!=imageUrl)
                view.imageUrl=imageUrl
        }
        @InverseBindingAdapter(attribute = "image_url")
        @JvmStatic fun getImageUrl(view: ProductImageView):String?{
            return view.imageUrl
        }
        fun displayImage(view: ImageView, imageUrl: String?){
            Glide.with(view.context)
                .setDefaultRequestOptions(
                    RequestOptions()
                        .placeholder(R.color.colorGrey)
                        .error(R.color.colorGrey)
                )
                .load(imageUrl)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(view)
        }
    }
}