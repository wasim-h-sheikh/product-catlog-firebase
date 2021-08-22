package com.qstest.util

import android.util.Log
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.facebook.shimmer.ShimmerFrameLayout
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class ProductBindingAdapter{

    companion object {
        @JvmStatic
        @BindingAdapter(value = ["shimmerViewContainer","product_id","parent_node", "error"], requireAll = false)
        fun fetchField(view: TextView, shimmerViewContainer: ShimmerFrameLayout?
                       ,productId: String?, parentNode: String?,error: Int) {

            if (!productId.isNullOrEmpty()&&!parentNode.isNullOrEmpty()) {
                val database = Firebase.database.reference
                shimmerViewContainer?.visibility= View.VISIBLE
                shimmerViewContainer?.startShimmer()
                val valueListener = object : ValueEventListener {
                    override fun onDataChange(dataSnapshot: DataSnapshot) {
                        shimmerViewContainer?.visibility= View.GONE
                        shimmerViewContainer?.stopShimmer()
                        dataSnapshot.value?.let {
                            if (it is String){
                                view.text = it
                            }else if(it is Long){
                                view.text = "₹ $it"
                            }

                        }
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
    }
}