package ru.pogosyan.module2

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

data class Contact(
    val name: String,
    val patronymic: String,
    val surname: String,
    val phone: String?,
    val address: String
)

val contacts = listOf(
    Contact("Евгений", "Андреевич", "Лукашин", "+7 495 495 95 95", "г. Москва, 3-я улица Строителей, д. 25, кв. 12"),
    Contact("Василий", "Егорович", "Кузякин", null, "Ивановская область, дер. Крутово, д. 4"),
    Contact("Людмила", "Прокофьевна", "Калугина", "+7 495 788 78 78", "Москва, Большая Никитская, д. 43, кв. 290")
)

// Задание 7.1. Контакт в виде колонки текстов, выровненных по левому краю
@Composable
fun ContactColumn(contact: Contact, modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text(text = "Имя: ${contact.name}")
        Text(text = "Отчество: ${contact.patronymic}")
        Text(text = "Фамилия: ${contact.surname}")
        Text(text = "Мобильный телефон: ${contact.phone ?: "---"}")
        Text(text = "Адрес: ${contact.address}")
    }
}

// Задание 7.2. Карточка контакта: серый фон, текст по центру
@Composable
fun ContactCard(contact: Contact, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(Color.LightGray)
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Имя: ${contact.name}", textAlign = TextAlign.Center)
        Text(text = "Отчество: ${contact.patronymic}", textAlign = TextAlign.Center)
        Text(text = "Фамилия: ${contact.surname}", textAlign = TextAlign.Center)
        Text(text = "Мобильный телефон: ${contact.phone ?: " ---"}", textAlign = TextAlign.Center)
        Text(text = "Адрес: ${contact.address}", textAlign = TextAlign.Center)
    }
}

// Список из нескольких карточек в контейнере Column
@Composable
fun ContactList(items: List<Contact>, modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(8.dp)) {
        items.forEach { contact ->
            ContactCard(contact)
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

// Задание 7.3. Карточка в контейнере Row: данные слева, изображение справа
@Composable
fun ContactRow(contact: Contact, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .padding(8.dp)
            .fillMaxWidth()
            .background(Color.LightGray)
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier.weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Имя: ${contact.name}")
            Text(text = "Отчество: ${contact.patronymic}")
            Text(text = "Фамилия: ${contact.surname}")
            Text(text = "Мобильный телефон: ${contact.phone ?: "---"}")
            Text(text = "Адрес: ${contact.address}", modifier = Modifier.fillMaxWidth())
        }
        Image(
            painter = painterResource(android.R.drawable.btn_star_big_on),
            contentDescription = "Избранное",
            modifier = Modifier.size(32.dp)
        )
    }
}

@Composable
fun ContactsScreen(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        ContactColumn(contacts[0])
        ContactList(contacts)
        ContactRow(contacts[0])
    }
}

@Preview(name = "ContactColumn", showSystemUi = true)
@Composable
fun ContactColumnPreview() {
    PreviewScreen {
        ContactColumn(contacts[0])
    }
}

@Preview(name = "List", showSystemUi = true)
@Composable
fun ListPreview() {
    PreviewScreen {
        ContactList(contacts)
    }
}

@Preview(name = "ContactRow", showSystemUi = true)
@Composable
fun ContactRowPreview() {
    PreviewScreen {
        ContactRow(contacts[0])
    }
}
