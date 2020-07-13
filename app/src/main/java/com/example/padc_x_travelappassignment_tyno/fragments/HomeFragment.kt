package com.example.padc_x_travelappassignment_tyno.fragments

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders

import com.example.padc_x_travelappassignment_tyno.R
import com.example.padc_x_travelappassignment_tyno.TourApp
import com.example.padc_x_travelappassignment_tyno.activities.DetailActivity
import com.example.padc_x_travelappassignment_tyno.adapters.CountryItemAdapter
import com.example.padc_x_travelappassignment_tyno.adapters.TourAdatper
import com.example.padc_x_travelappassignment_tyno.data.models.TourModel
import com.example.padc_x_travelappassignment_tyno.data.models.TourModelImpl
import com.example.padc_x_travelappassignment_tyno.data.vos.TourAndCountryVO
import com.example.padc_x_travelappassignment_tyno.mvp.presenters.MainPresenter
import com.example.padc_x_travelappassignment_tyno.mvp.presenters.MainPresenterImpl
import com.example.padc_x_travelappassignment_tyno.mvp.views.MainView

import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home.ivEmptyImage
import kotlinx.android.synthetic.main.viewpod_empty.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [HomeFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment(), MainView {

    lateinit var presenter : MainPresenter
    lateinit var countryItemAdapter: CountryItemAdapter
    lateinit var tourAdatper: TourAdatper
    lateinit var tourModel: TourModel

    override fun hideEmptyView() {
        ivEmptyImage.visibility= View.GONE
    }

    override fun enableSwipeRefresh() {
        swipeRefreshLayout.isRefreshing = true
    }

    override fun disableSwipeRefresh() {
       swipeRefreshLayout.isRefreshing = false
    }

    override fun showList(list: TourAndCountryVO) {
        hideEmptyView()
        tourAdatper.setNewData(list.tours.toMutableList())
        countryItemAdapter.setNewData(list.countries.toMutableList())
    }

    override fun showErrorMessage(message: String) {
        tvEmpty.setText("Error")
    }

    override fun displayEmptyView() {
        ivEmptyImage.visibility= View.VISIBLE
    }

    override fun navigateDetail(name: String) {
        context?.let {
            startActivity(DetailActivity.newInstance(it, name))
        }
    }


    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var listener: OnFragmentInteractionListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       return inflater.inflate(R.layout.fragment_home, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

     presenter= ViewModelProviders.of(activity!!).get(MainPresenterImpl::class.java)

       presenter.initPresenter(this)
        tourModel = TourModelImpl

        enableSwipeRefresh()
        countryItemAdapter= CountryItemAdapter(presenter)
        tourAdatper = TourAdatper(presenter)
        setUpRecycler()
        presenter.onUiReady(this)
    }

    private fun setUpRecycler(){
        rvPopularTours.adapter = tourAdatper
        rvCountry.adapter = countryItemAdapter
    }

    // TODO: Rename method, update argument and hook method into UI event
//    override fun onButtonPressed(uri: Uri) {
//        listener?.onFragmentInteraction(uri)
//    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            listener = context
        }
//        else {
//            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
//        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     *
     *
     * See the Android Training lesson [Communicating with Other Fragments]
     * (http://developer.android.com/training/basics/fragments/communicating.html)
     * for more information.
     */
    interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onFragmentInteraction(uri: Uri)
    }

    companion object {

       val TAG = "Go to Favourite fragment"
//        @JvmStatic
//        fun newInstance() = HomeFragment()
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HomeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }


    }
}
