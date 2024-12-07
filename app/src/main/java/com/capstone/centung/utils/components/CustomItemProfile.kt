package com.capstone.centung.utils.components

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import androidx.core.content.res.use
import com.capstone.centung.R
import com.capstone.centung.databinding.CustomItemProfileBinding

class CustomItemProfile @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
) : FrameLayout(context, attrs, defStyleAttr) {

    private val binding: CustomItemProfileBinding

    init {
        binding = CustomItemProfileBinding.inflate(LayoutInflater.from(context), this, true)

        context.theme.obtainStyledAttributes(attrs, R.styleable.CustomItemProfile, defStyleAttr, 0)
            .use { typedArray ->
                val drawable: Drawable? =
                    typedArray.getDrawable(R.styleable.CustomItemProfile_addImg)
                drawable?.let { binding.ivAddImg.setImageDrawable(it) }

                val text: String? = typedArray.getString(R.styleable.CustomItemProfile_addText)
                binding.tvAddText.text = text

                val visibility = typedArray.getInt(
                    R.styleable.CustomItemProfile_dividerVisibility,
                    VISIBLE
                )
                binding.divider.visibility = when (visibility) {
                    1 -> INVISIBLE
                    2 -> GONE
                    else -> VISIBLE
                }
            }
    }
    fun setDividerVisibility(visibility: Int) {
        binding.divider.visibility = visibility
    }
    fun setDrawable(drawable: Drawable?) {
        binding.ivAddImg.setImageDrawable(drawable)
    }

    fun setText(text: String?) {
        binding.tvAddText.text = text
    }

    fun setOnRootClickListener(listener: OnClickListener) {
        binding.root.setOnClickListener(listener)
    }
}
