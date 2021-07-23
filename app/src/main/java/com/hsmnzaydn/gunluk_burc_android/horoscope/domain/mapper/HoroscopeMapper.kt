import com.hsmnzaydn.gunluk_burc_android.horoscope.data.entities.DescriptionResponse
import com.hsmnzaydn.gunluk_burc_android.horoscope.data.entities.HoroscopeResponse
import com.hsmnzaydn.gunluk_burc_android.horoscope.domain.entities.Description
import com.hsmnzaydn.gunluk_burc_android.horoscope.domain.entities.Horoscope

fun HoroscopeResponse.toHoroscope(): Horoscope = Horoscope(
    "https://"+imagePath,
    id,
    horoscopeName,
    descriptions = this.descriptionResponse?.map {
        it.toDescription()
    }?: emptyList()
)

fun DescriptionResponse.toDescription(): Description = Description(
    title,
    description
)