package com.hackathon.happydiary.base

import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hackathon.happydiary.model.MetaData
import com.hackathon.happydiary.utils.DLog

abstract class ListMoreScrollListener : RecyclerView.OnScrollListener() {

    companion object {
        val TAG = ListMoreScrollListener::class.java.simpleName
    }

    private var loading = true              // 스크롤 허용 유무

    private var mPage = 1                   // 현재 호출 페이지


    /**
     * 사용가능한 params
     * MetaData {
     *    totalCount      : 검색된 문서 수
     *    pageableCount   : total_count 중 노출 가능 문서 수
     *    isEnd           : 현재 페이지가 마지막 페이지인지 여부, 값이 false면 page를 증가시켜 다음 페이지를 요청할 수 있음
     *
     * }
     */

    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        super.onScrolled(recyclerView, dx, dy)

        with(recyclerView) {

            when (layoutManager?.javaClass?.simpleName) {

                GridLayoutManager::class.java.simpleName -> {
                    (layoutManager as GridLayoutManager).apply {
                        if (loading) {

                            val visibleItemCount = childCount                                           // 화면에 보이는 아이템 갯수
                            val totalItemCount = itemCount                                              // 아이템 전체 갯수
                            val pastVisibleItems = findFirstCompletelyVisibleItemPosition()             // 첫번째로 표시되는 아이템 포지션
                            val lastVisibleItemPosition = findLastCompletelyVisibleItemPosition()       // 현재화면에 출력된 리스트중 마지막 View의 Position을 반환
                            val loadPreparationCount = visibleItemCount + spanCount

                            val metaInfo: MetaData = getMetaInfo()
                            val isEnd = metaInfo.isEnd
                            if (isEnd) {
                                loadingStatus(false)
                                onCompletedLoading()
                            } else if (lastVisibleItemPosition + loadPreparationCount >= totalItemCount) {
                                loadingStatus(false)
                                // 현재화면에 출력된 리스트중 마지막 View의 Position을 기준으로 loadPreparationCount 크기만큼 남았을 때, 다음 페이지 API 호출
                                mPage++
                                onLoadData(mPage)
                            }
                        }


                    }
                }

                else -> DLog.e(TAG, "Different LayoutManager")
            }
        }
    }

    abstract fun getMetaInfo(): MetaData

    /**
     * page 단위로 구분해서 처리할 경우가 발생할 수 있어서 page도 카운팅한다.
     */
    abstract fun onLoadData(page: Int)

    /**
     * API 호출이 끝날경우
     */
    abstract fun onCompletedLoading()

    /**
     * API가 호출되는 동안 여러번 호추될 수 있어 loading 값을 통해 제어한다.
     */
    fun loadingStatus(status: Boolean) {
        loading = status
    }

}