package com.capstone.centung.ui.about_stunting

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.text.HtmlCompat
import com.capstone.centung.R
import com.capstone.centung.databinding.ActivityAboutStuntingBinding

class AboutStuntingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAboutStuntingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAboutStuntingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupDesc()
        setupActionBackToolBar()

    }

    private fun setupDesc() {
        val formattedText = """
                <b>Stunting</b> adalah kondisi gangguan pertumbuhan pada anak yang disebabkan oleh kekurangan gizi kronis, terutama selama 1.000 hari pertama kehidupan, yaitu dari masa kehamilan hingga anak berusia dua tahun. Anak yang mengalami stunting memiliki tinggi badan yang lebih rendah dari standar usianya, tetapi masalah ini bukan hanya soal fisik.<br><br>

                <b>Dampak stunting:</b><br><br>
                1. Kognitif: Menghambat perkembangan otak, yang dapat memengaruhi kemampuan belajar dan produktivitas di masa depan.<br><br>
                2. Kesehatan: Anak lebih rentan terhadap penyakit dan gangguan metabolisme saat dewasa.<br><br>
                3. Psikososial: Dapat mengurangi kepercayaan diri dan kualitas hidup.<br><br>

                <b>Penyebab utama stunting:</b><br><br>
                1. Kekurangan gizi selama masa kehamilan dan balita.<br><br>
                2. Praktik pemberian makan yang tidak memadai.<br><br>
                3. Sanitasi dan akses air bersih yang buruk.<br><br>
                4. Kurangnya edukasi ibu mengenai pola asuh dan gizi.<br><br>

                <b>Pencegahan stunting:</b><br><br>
                1. Asupan gizi yang cukup selama masa kehamilan dan menyusui.<br><br>
                2. Member ikan ASI eksklusif selama 6 bulan pertama.<br><br>
                3. Pola makan yang sehat dan seimbang setelah masa ASI eksklusif.<br><br>
                4. Akses ke layanan kesehatan, imunisasi, dan pengobatan.<br><br>
                5. Perbaikan sanitasi dan penyediaan air bersih.<br><br>

                Pemerintah Indonesia telah menjadikan pencegahan stunting sebagai salah satu prioritas nasional dengan berbagai program, seperti pemberian makanan tambahan, penyuluhan kesehatan, dan kampanye sanitasi.
            """.trimIndent()

        binding.tvDesc.text = HtmlCompat.fromHtml(formattedText, HtmlCompat.FROM_HTML_MODE_LEGACY)
    }

    private fun setupActionBackToolBar() {
        binding.apply {
            setSupportActionBar(mToolbar)
            mToolbar.apply {
                setNavigationIcon(R.drawable.ic_arrow_back)
                setNavigationOnClickListener {
                    onBackPressedDispatcher.onBackPressed()
                }
            }
        }
    }
}