package com.example.appactivity5

import androidx.annotation.ColorRes
import androidx.annotation.DimenRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import androidx.core.content.res.ResourcesCompat

@Composable
private fun spResource(@DimenRes id: Int): TextUnit = dimensionResource(id).value.sp

@Composable
fun KartuMahasiswa(
    @StringRes nama: Int,
    @StringRes alamat: Int,
    @ColorRes warnaLatar: Int,
    @ColorRes warnaAlamat: Int,
    modifier: Modifier = Modifier,
    @StringRes telepon: Int? = null,
    fontNama: FontFamily = FontFamily.Default,
    bobotNama: FontWeight = FontWeight.Bold
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = dimensionResource(R.dimen.padding_kartu)),
        shape = RoundedCornerShape(dimensionResource(R.dimen.radius_kartu)),
        colors = CardDefaults.cardColors(
            containerColor = colorResource(warnaLatar)
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(dimensionResource(R.dimen.padding_dalam_kartu)),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(R.drawable.logo_umy),
                contentDescription = stringResource(R.string.desc_logo),
                modifier = Modifier.size(dimensionResource(R.dimen.ukuran_logo))
            )
            Spacer(modifier = Modifier.width(dimensionResource(R.dimen.jarak_logo_teks)))
            Column(
                modifier = Modifier.weight(
                    ResourcesCompat.getFloat(
                        LocalContext.current.resources,
                        R.dimen.bobot_teks
                    )
                ),
                verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.jarak_antar_teks))
            ) {
                Text(
                    text = stringResource(nama),
                    fontSize = spResource(R.dimen.ukuran_nama),
                    fontFamily = fontNama,
                    fontWeight = bobotNama,
                    color = colorResource(R.color.teks_putih)
                )
                telepon?.let {
                    Text(
                        text = stringResource(it),
                        fontSize = spResource(R.dimen.ukuran_info),
                        color = colorResource(R.color.teks_cyan)
                    )
                }
                Text(
                    text = stringResource(alamat),
                    fontSize = spResource(R.dimen.ukuran_info),
                    color = colorResource(warnaAlamat)
                )
            }
            Spacer(modifier = Modifier.width(dimensionResource(R.dimen.jarak_logo_teks)))
            Image(
                painter = painterResource(R.drawable.logo_umy),
                contentDescription = stringResource(R.string.desc_logo),
                modifier = Modifier.size(dimensionResource(R.dimen.ukuran_logo))
            )
        }
    }
}

@Composable
fun TampilanUtama(modifier: Modifier = Modifier) {
    Box(modifier = modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = dimensionResource(R.dimen.jarak_atas_layar)),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.jarak_kartu))
        ) {
            Text(
                text = stringResource(R.string.prodi),
                fontSize = spResource(R.dimen.ukuran_judul),
                fontWeight = FontWeight.Bold,
                color = colorResource(R.color.teks_judul)
            )
            Text(
                text = stringResource(R.string.univ),
                fontSize = spResource(R.dimen.ukuran_subjudul),
                fontWeight = FontWeight.Bold,
                color = colorResource(R.color.teks_judul)
            )
            KartuMahasiswa(
                nama = R.string.nama_1,
                alamat = R.string.alamat_1,
                warnaLatar = R.color.card_1_bg,
                warnaAlamat = R.color.teks_kuning,
                fontNama = FontFamily.Cursive,
                bobotNama = FontWeight.Normal
            )
            KartuMahasiswa(
                nama = R.string.nama_2,
                telepon = R.string.telepon_2,
                alamat = R.string.alamat_2,
                warnaLatar = R.color.card_2_bg,
                warnaAlamat = R.color.teks_kuning
            )
            KartuMahasiswa(
                nama = R.string.nama_3,
                telepon = R.string.telepon_3,
                alamat = R.string.alamat_3,
                warnaLatar = R.color.card_3_bg,
                warnaAlamat = R.color.teks_putih
            )
        }
    }
}