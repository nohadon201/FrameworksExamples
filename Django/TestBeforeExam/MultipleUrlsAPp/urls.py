from django.urls import path
from MultipleUrlsAPp.views import MultipleURL

app_name='multipleurl'

urlpatterns = [
    path('', MultipleURL.as_view()),
]
