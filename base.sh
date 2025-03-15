#!/bin/bash

# Получаем имя удаленного репозитория от пользователя
read -p "Введите имя удаленного репозитория: " remote_name

# Получаем имя ветки от пользователя
read -p "Введите имя ветки: " branch_name

# Сообщение коммита
commit_message="Automatic commit"

# Добавляем все изменения
git add .

git commit -m "$commit_message"

git push origin "$branch_name"