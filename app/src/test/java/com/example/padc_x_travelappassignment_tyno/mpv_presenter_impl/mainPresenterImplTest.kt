package com.example.padc_x_travelappassignment_tyno.mpv_presenter_impl

import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.padc_x_travelappassignment_tyno.TourApp.Companion.context
import com.example.padc_x_travelappassignment_tyno.data.models.TourModel
import com.example.padc_x_travelappassignment_tyno.data.models.TourModelImpl
import com.example.padc_x_travelappassignment_tyno.data.vos.TourVO
import com.example.padc_x_travelappassignment_tyno.mvp.presenters.MainPresenter
import com.example.padc_x_travelappassignment_tyno.mvp.presenters.MainPresenterImpl
import com.example.padc_x_travelappassignment_tyno.mvp.views.MainView
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.verify
import org.apache.tools.ant.Main
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config
import javax.inject.Inject

@RunWith(AndroidJUnit4::class)
@Config(manifest = Config.NONE)
class mainPresenterImplTest{
    private lateinit var mPresenter : MainPresenterImpl

    @RelaxedMockK
    private lateinit var mView: MainView

    private lateinit var mModel : TourModel



    @Before
    fun setUpPresenter() {
        MockKAnnotations.init(this)

        TourModelImpl.initDB(ApplicationProvider.getApplicationContext())
        mModel = TourModelImpl

        mPresenter = MainPresenterImpl()
        mPresenter.initPresenter(mView)
        mPresenter.model = this.mModel
}

    @Test
    fun onTapNavigate_toDetailActivity() {
        var tapTour = TourVO()
        tapTour.name = "Florance"
        mPresenter.onTap(tapTour.name)
        verify {
            mView.navigateDetail(tapTour.name)
        }
    }
}