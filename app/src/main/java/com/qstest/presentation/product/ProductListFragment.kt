package com.qstest.presentation.product

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.qstest.R
import com.qstest.databinding.ProductListFragmentBinding
import com.qstest.presentation.di.Injector
import com.qstest.util.toProducts
import javax.inject.Inject

class ProductListFragment : Fragment() {

    @Inject
    lateinit var factory: ProductListViewModelFactory
    private lateinit var productListViewModel: ProductListViewModel
    private lateinit var binding: ProductListFragmentBinding
    private lateinit var adapter: ProductListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.product_list_fragment, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        productListViewModel = ViewModelProvider(this,factory).get(ProductListViewModel::class.java)
        initRecyclerView()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (activity?.application as Injector).createProductSubComponent().inject(this)
    }


    private fun initRecyclerView(){
        binding.productRecyclerView.layoutManager = LinearLayoutManager(activity)
        adapter = ProductListAdapter()
        binding.productRecyclerView.adapter = adapter

        displayProducts()
    }

    private fun displayProducts(){
        binding.videoProgressBar.visibility = View.VISIBLE
        val responseLiveData = productListViewModel.getProductsIds()
        responseLiveData.observe(viewLifecycleOwner, Observer {
            if(it!=null){
                adapter.setList(it.toProducts())
                binding.videoProgressBar.visibility = View.GONE
            }else{
                binding.videoProgressBar.visibility = View.GONE
                Toast.makeText(activity,"No data available", Toast.LENGTH_LONG).show()
            }
        })
    }
}