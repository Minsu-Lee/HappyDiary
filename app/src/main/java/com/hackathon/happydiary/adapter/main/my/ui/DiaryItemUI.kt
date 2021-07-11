package com.hackathon.happydiary.adapter.main.my.ui

import android.graphics.Color
import android.text.TextUtils
import android.util.TypedValue
import android.view.Gravity
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import com.hackathon.happydiary.R
import com.hackathon.happydiary.extensions.squareImageView
import com.hackathon.happydiary.view.component.SquareImageView
import org.jetbrains.anko.*

class DiaryItemUI: AnkoComponent<ViewGroup> {

    lateinit var profileIv: SquareImageView
    lateinit var userNickName: TextView
    lateinit var contentIv: SquareImageView

    lateinit var likeLl: LinearLayout
    lateinit var likeIv: SquareImageView
    lateinit var likeCntTv: TextView

    lateinit var commentLl: LinearLayout
    lateinit var commentIv: SquareImageView
    lateinit var commentCntTv: TextView

    lateinit var lockLl: LinearLayout
    lateinit var lockIv: SquareImageView

    lateinit var menuLl: LinearLayout
    lateinit var menuIv: SquareImageView

    lateinit var weatherIv: SquareImageView
    lateinit var weatherTv: TextView
    lateinit var contentTv: TextView
    lateinit var hashtagTv: TextView
    lateinit var dateTv: TextView

    override fun createView(ui: AnkoContext<ViewGroup>) = with(ui) {
        verticalLayout {
            lparams(width= matchParent, height= wrapContent) {
                backgroundColor = Color.WHITE
                horizontalPadding = dip(20)
                bottomPadding = dip(40)

                linearLayout {
                    orientation = LinearLayout.HORIZONTAL
                    gravity = Gravity.CENTER_VERTICAL

                    profileIv = squareImageView {
                    }.lparams(width= dip(32)) {
                        rightMargin = dip(10)
                    }

                    userNickName = textView("유니콘") {

                        typeface = ResourcesCompat.getFont(context, R.font.notosans_cjk_bold)
                        setTextSize(TypedValue.COMPLEX_UNIT_PX, resources.getDimension(R.dimen.diary_nickname_text_size))
                        textColor = Color.parseColor("#1A1A1A")
                        setLineSpacing(resources.getDimension(R.dimen.diary_nickname_text_line_height), 1.0f)
                        gravity = Gravity.CENTER

                    }.lparams(width= dip(32))

                }.lparams(width= matchParent, height= dip(32)) {
                    bottomMargin = dip(10)
                }

                contentIv = squareImageView {
                    backgroundColor = Color.LTGRAY
                }.lparams(width= matchParent) {
                    bottomMargin = dip(5)
                }

                linearLayout {
                    orientation = LinearLayout.HORIZONTAL

                    /**
                     * isLike
                     */
                    likeLl = linearLayout {
                        orientation = LinearLayout.HORIZONTAL
                        gravity = Gravity.CENTER_VERTICAL

                        likeIv = squareImageView {
                            backgroundResource = R.drawable.ic_clap_img
                        }.lparams(width= dip(20)) {
                            rightMargin = dip(2)
                        }

                        likeCntTv = textView("0") {

                            typeface = ResourcesCompat.getFont(context, R.font.nunito_black)
                            setTextSize(TypedValue.COMPLEX_UNIT_PX, resources.getDimension(R.dimen.diary_like_cnt_text_size))
                            textColor = Color.parseColor("#1A1A1A")
                            setLineSpacing(resources.getDimension(R.dimen.diary_like_cnt_text_line_height), 1.0f)
                            gravity = Gravity.CENTER

                        }.lparams(width= wrapContent, height= wrapContent)

                    }.lparams(width= wrapContent, height= dip(25)) {
                        rightMargin = dip(16)
                    }

                    /**
                     * comment
                     */
                    commentLl = linearLayout {
                        orientation = LinearLayout.HORIZONTAL
                        gravity = Gravity.CENTER_VERTICAL

                        commentIv = squareImageView {
                            backgroundResource = R.drawable.ic_comment_img
                        }.lparams(width= dip(20)) {
                            rightMargin = dip(2)
                        }

                        commentCntTv = textView("0") {

                            typeface = ResourcesCompat.getFont(context, R.font.nunito_black)
                            setTextSize(TypedValue.COMPLEX_UNIT_PX, resources.getDimension(R.dimen.diary_like_cnt_text_size))
                            textColor = Color.parseColor("#1A1A1A")
                            setLineSpacing(resources.getDimension(R.dimen.diary_like_cnt_text_line_height), 1.0f)
                            gravity = Gravity.CENTER

                        }.lparams(width= wrapContent, height= wrapContent)

                    }.lparams(width= wrapContent, height= dip(25))

                    /**
                     * isLock
                     */
                    lockLl = linearLayout {
                        orientation = LinearLayout.HORIZONTAL
                        gravity = Gravity.CENTER_VERTICAL

                        lockIv = squareImageView {
                            backgroundResource = R.drawable.ic_lock_img
                        }.lparams(width= dip(20))

                    }.lparams(width= wrapContent, height= dip(25)) {
                        leftMargin = dip(16)
                    }

                    view { backgroundColor = Color.TRANSPARENT }.lparams(width= wrapContent, height= dip(1), weight= 1f)

                    /**
                     * menu
                     */
                    menuLl = linearLayout {
                        orientation = LinearLayout.HORIZONTAL
                        gravity = Gravity.CENTER_VERTICAL

                        menuIv = squareImageView {
                            backgroundResource = R.drawable.ic_lock_img
                        }.lparams(width= dip(20))

                    }.lparams(width= wrapContent, height= dip(25))

                }.lparams(width= matchParent, height= dip(30)) {
                    bottomMargin = dip(5)
                }

                /**
                 * Weather
                 */
                linearLayout {

                    weatherIv = squareImageView {
                    }.lparams(width= dip(20)) {
                        rightMargin = dip(4)
                    }

                    weatherTv = textView("행복") {

                        typeface = ResourcesCompat.getFont(context, R.font.notosans_cjk_bold)
                        setTextSize(TypedValue.COMPLEX_UNIT_PX, resources.getDimension(R.dimen.diary_weather_text_size))
                        textColor = Color.parseColor("#1A1A1A")
                        setLineSpacing(resources.getDimension(R.dimen.diary_weather_text_line_height), 1.0f)
                        gravity = Gravity.CENTER

                    }.lparams(width= wrapContent, height= wrapContent)

                }.lparams(width= wrapContent, height= dip(20)) {
                    bottomMargin = dip(4)
                }

                /**
                 * Content
                 */
                contentTv = textView {

                    typeface = ResourcesCompat.getFont(context, R.font.notosans_cjk_medium)
                    setTextSize(TypedValue.COMPLEX_UNIT_PX, resources.getDimension(R.dimen.diary_content_text_size))
                    textColor = Color.parseColor("#1A1A1A")
                    setLineSpacing(resources.getDimension(R.dimen.diary_content_text_line_height), 1.0f)
                    ellipsize = TextUtils.TruncateAt.END
                    lines = 2

                }.lparams(width= wrapContent, height= wrapContent) {
                    bottomMargin = dip(4)
                }

                /**
                 * Hashtag
                 */
                hashtagTv = textView {

                    typeface = ResourcesCompat.getFont(context, R.font.notosans_cjk_medium)
                    setTextSize(TypedValue.COMPLEX_UNIT_PX, resources.getDimension(R.dimen.diary_hashtag_text_size))
                    textColor = Color.parseColor("#6B53FF")
                    setLineSpacing(resources.getDimension(R.dimen.diary_hashtag_text_line_height), 1.0f)
                    ellipsize = TextUtils.TruncateAt.END
                    lines = 1

                }.lparams(width= wrapContent, height= wrapContent) {
                    bottomMargin = dip(10)
                }

                /**
                 * Date
                 */
                dateTv = textView {

                    typeface = ResourcesCompat.getFont(context, R.font.nunito_regular)
                    setTextSize(TypedValue.COMPLEX_UNIT_PX, resources.getDimension(R.dimen.diary_date_text_size))
                    textColor = Color.parseColor("#999999")
                    setLineSpacing(resources.getDimension(R.dimen.diary_date_text_line_height), 1.0f)

                }.lparams(width= wrapContent, height= wrapContent) {
                    bottomMargin = dip(10)
                }

            }
        }
    }
}