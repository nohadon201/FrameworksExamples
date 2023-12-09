<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Laravel Pol G: Superzing</title>
</head>
<body>
@extends('layouts.app')
@section('content')
<div class="container">
        @if ($message = Session::get('success'))
            <div class="alert alert-success alert-block">
                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                <strong>{{ $message }}</strong>
            </div>

        @endif
        <div class="card">
            <div class="card-header">Superzings associat al usuari {{$user->name}}</div>


            <div class="card-body">

                <table class="table table-striped table-hover mb-5">
                    <thead>
                    <tr>
                        <th>idSuperzing</th>
                        <th>Nom Superzing</th>
                        <th>Empresonat</th>
                        <th>Perillos</th>
                        <th>numDiesPreso</th>
                    </tr>
                    </thead>
                    <tbody>
                    @foreach($elements as $element)
                        @if($element->idUser === $user -> idUser)
                            <tr id="{{$element->idSuperzing}}">
                                <td> {{$element->idSuperzing}} </td>
                                <td> {{$element->Nom}} </td>
                                <td> {{$element->Empresonat}} </td>
                                <td> {{$element->Perillos}} </td>
                                <td> {{$element->numDiesPreso}} </td>
                            </tr>
                        @endif
                    @endforeach
                    </tbody>
                </table>
            </div>
        </div>
    </div>
@endsection

</body>
</html>