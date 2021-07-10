package com.hackathon.happydiary.base

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import java.util.*

abstract class BaseRecyclerAdapter<ITEM, VH: RecyclerView.ViewHolder>: RecyclerView.Adapter<VH>() {

    companion object {
        const val TYPE_HEADER = Integer.MIN_VALUE
        const val TYPE_FOOTER = Integer.MIN_VALUE + 1
    }

    abstract val ctx: Context
    open var list: ArrayList<ITEM> = arrayListOf()
    var rv: RecyclerView? = null

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        rv = recyclerView
    }

    /**
     * ViewHolder Type
     * getItemViewType 재정의가 필요할 시, getViewType 메서드를 재정의
     * fun getViewType(position: Int): Int
     */
    open fun getViewType(position: Int) = position
    override fun getItemViewType(position: Int): Int {
        return when {
            (position == 0 && useHeader()) -> TYPE_HEADER
            (position == itemCount - 1 && useFooter()) -> TYPE_FOOTER
            else -> (if (useHeader()) position - 1 else position).let(this::getViewType)
        }
    }

    /**
     * Create ViewHolder
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH
            = when (viewType) {
        TYPE_HEADER -> onCreateHeaderViewHolder(parent, viewType)!!
        TYPE_FOOTER -> onCreateFooterViewHolder(parent, viewType)!!
        else -> onCreateBasicViewHolder(parent, viewType)
    }

    /**
     * Bind ViewHolder
     */
    override fun onBindViewHolder(holder: VH, position: Int) {

        // ViewHolder Parent ClickListener
        holder.itemView.setOnClickListener {
            this.onViewHolderClickListener?.invoke(it, -1, position)
        }

        when {
            (position == 0 && useHeader()) -> onBindHeaderItemView(holder, position)
            (position == itemCount - 1 && useFooter()) -> onBindFooterItemView(holder, position)
            else -> {
                val basicPosition = if (useHeader()) position - 1 else position
                onBindBasicItemView(holder, basicPosition)
            }
        }
    }

    /**
     * 재정의 금지!
     */
    override fun getItemCount(): Int {
        var itemCount = list.size
        if (useHeader()) itemCount += 1
        if (useFooter()) itemCount += 1
        return itemCount
    }

    /**
     * Default View Holder ( require )
     */
    abstract fun onCreateBasicViewHolder(parent: ViewGroup, viewType: Int): VH
    abstract fun onBindBasicItemView(holder: VH?, position: Int)

    /**
     * Header ( optional )
     */
    open fun useHeader() = false
    open fun onCreateHeaderViewHolder(parent: ViewGroup, viewType: Int): VH? = null
    open fun onBindHeaderItemView(holder: VH, position: Int) {}

    /**
     * Footer ( optional )
     */
    open fun useFooter() = false
    open fun onCreateFooterViewHolder(parent: ViewGroup, viewType: Int): VH? = null
    open fun onBindFooterItemView(holder: VH, position: Int) {}

    /**
     * ViewHolder Parent ClickListener ( optional )
     */
    private var onViewHolderClickListener: ((view: View, id: Int, position: Int) -> Unit)? = null
    fun setOnItemClickListener(onViewHolderClickListener: (view: View, id: Int, position: Int) -> Unit) {
        this.onViewHolderClickListener = onViewHolderClickListener
    }
    fun removeOnItemClickListener() { this.onViewHolderClickListener = null }

}