package jo.kotlin.mvpsample.view

import com.nhaarman.mockitokotlin2.*
import jo.kotlin.mvpsample.BuildConfig
import jo.kotlin.mvpsample.HomePresenter
import jo.kotlin.mvpsample.MainContract
import jo.kotlin.mvpsample.dummy.DummyHomePresenter
import jo.kotlin.mvpsample.remote.MainDataSource
import jo.kotlin.mvpsample.remote.MainRepository
import jo.kotlin.mvpsample.view.adapter.MainAdapterContract
import jo.kotlin.mvpsample.view.data.Photo
import jo.kotlin.mvpsample.view.data.PhotoResponse
import jo.kotlin.mvpsample.view.data.Photos
import junit.framework.Assert.assertEquals
import org.junit.After
import org.junit.Before
import org.junit.Test

import org.mockito.*

import org.mockito.ArgumentCaptor
import org.mockito.BDDMockito.given
import org.mockito.BDDMockito.willDoNothing


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

    @Mock
    private lateinit var Photos : Photos;

    @Mock
    private lateinit var callback: MainDataSource.LoadFlickrCallback;

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

    @Captor
    private lateinit var argumentCaptor : ArgumentCaptor<MainDataSource.LoadFlickrCallback>

    @Test
    fun loadFlickrPhotos() {

        given(photoResponse.stat).willReturn("ok");
        given(photoResponse.photos).willReturn(Photos)
        given(Photos.photo).willReturn(arrayListOf())
        doNothing().`when`(mainAdapterContractModel).addItems(any())

        Mockito.doAnswer{
//            println(it);
            it.getArgument<MainDataSource.LoadFlickrCallback>(7).onSuccess(photoResponse)
            null;
        }.`when`(mainRepository).getSearchPhotos(any(), any(), any(), any(), any() , any(), any(), any())


        homePresenter.loadFlickrPhotos()
        verify(mainContractView).showProgress()
        verify(mainContractView).hideProgress()
        verify(mainAdapterContractModel).addItems(any())
        verify(mainAdapterContractView).updateView()

    }

}