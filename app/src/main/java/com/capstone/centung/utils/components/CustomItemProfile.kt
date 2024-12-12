package com.capstone.centung.utils.components

import android.content.Context
import android.graphics.drawable.Drawable
import android.os.Build
import android.text.SpannableString
import android.text.style.UnderlineSpan
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import androidx.annotation.RequiresApi
import androidx.core.content.res.use
import com.capstone.centung.R
import com.capstone.centung.databinding.CustomItemProfileBinding

@RequiresApi(Build.VERSION_CODES.M)
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

                val textColor = typedArray.getColor(
                    R.styleable.CustomItemProfile_addTextColor,
                    context.getColor(R.color.black)
                )
                binding.tvAddText.setTextColor(textColor)

                val visibility = typedArray.getInt(
                    R.styleable.CustomItemProfile_dividerVisibility,
                    VISIBLE
                )
                binding.divider.visibility = when (visibility) {
                    1 -> INVISIBLE
                    2 -> GONE
                    else -> VISIBLE
                }
                val isUnderlined =
                    typedArray.getBoolean(R.styleable.CustomItemProfile_addTextUnderline, false)
                if (isUnderlined) {
                    setUnderlinedText(text ?: "")
                } else {
                    binding.tvAddText.text = text
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

    fun setUnderlinedText(text: String?) {
        val spannableString = SpannableString(text)
        spannableString.setSpan(UnderlineSpan(), 0, spannableString.length, 0)
        binding.tvAddText.text = spannableString
    }

    fun setOnRootClickListener(listener: OnClickListener) {
        binding.root.setOnClickListener(listener)
    }
}
