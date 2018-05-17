package jo.kotlin.mvpsample.view

import com.nhaarman.mockitokotlin2.capture
import com.nhaarman.mockitokotlin2.eq
import com.nhaarman.mockitokotlin2.verify
import jo.kotlin.mvpsample.BuildConfig
import jo.kotlin.mvpsample.HomePresenter
import jo.kotlin.mvpsample.MainContract
import jo.kotlin.mvpsample.dummy.DummyHomePresenter
import jo.kotlin.mvpsample.remote.MainDataSource
import jo.kotlin.mvpsample.remote.MainRepository
import jo.kotlin.mvpsample.view.adapter.MainAdapterContract
import jo.kotlin.mvpsample.view.data.PhotoResponse
import junit.framework.Assert.assertEquals
import org.junit.After
import org.junit.Before
import org.junit.Test

import org.mockito.*

import org.mockito.ArgumentCaptor


/**
 * Created by Jo on 2018. 5. 15.
 */

class HomePresenterTest {

    @Mock
    private lateinit var mainContractView: MainContract.View
    @Mock
    private lateinit var mainAdapterContractView: MainAdapterContract.View
    @Mock
    private lateinit var mainAdapterContractModel: MainAdapterContract.Model
    @Mock
    private lateinit var mainRepository: MainRepository

//    @Mock
//    private lateinit var dummyHomePresenter: DummyHomePresenter

    @Captor
    private val getLoadFlickrCallbackCaptor:
            ArgumentCaptor<MainDataSource.LoadFlickrCallback> = ArgumentCaptor.forClass(MainDataSource.LoadFlickrCallback::class.java)

    @Mock
    private lateinit var photoResponse: PhotoResponse

    private lateinit var homePresenter: HomePresenter
    @Before
    fun setUp() {

        MockitoAnnotations.initMocks(this)

//        mainContractView = Mockito.mock(MainContract.View::class.java)
//        mainAdapterContractView = Mockito.mock(MainAdapterContract.View::class.java)
//        mainAdapterContractModel = Mockito.mock(MainAdapterContract.Model::class.java)
//        mainRepository = Mockito.mock(MainRepository::class.java)

//        dummyHomePresenter = Mockito.mock(DummyHomePresenter(mainRepository)::class.java)

//        photoResponse = Mockito.mock(PhotoResponse::class.java)

        homePresenter = HomePresenter(mainContractView, mainRepository, mainAdapterContractView, mainAdapterContractModel)
    }

    @After
    fun tearDown() {
    }

    @Test
    fun loadFlickrPhotos() {
        homePresenter.loadFlickrPhotos()

        verify(mainRepository).getSearchPhotos(eq("json"), eq("1"),
                eq("flickr.photos.search"), eq("LOVE"), eq(BuildConfig.FLICKR_API_KEY), eq(1),
                eq(200), capture(getLoadFlickrCallbackCaptor))

//        getLoadFlickrCallbackCaptor.value.onSuccess(photoResponse)

//        assertEquals(1, getLoadFlickrCallbackCaptor.allValues.size)
//
//        var a :Int = getLoadFlickrCallbackCaptor.allValues.size
//        System.out.println("a = $a")

//        getLoadFlickrCallbackCaptor.value.onSuccess(photoResponse)

        verify(homePresenter.view).showProgress()

//        Thread.sleep(3000)
//        verify(homePresenter.view).hideProgress()
    }

}