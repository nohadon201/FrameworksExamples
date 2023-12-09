<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use Illuminate\Support\Facades\Auth;
use App\Models\User;
use App\Models\Superzing;

class SuperzingController extends Controller
{
    public function index(){
        $user = User::findOrFail(Auth::user()->idUser);
        $elements = Superzing::all();
        if($user -> password)
        return view('index',['user'=>$user,'elements'=>$elements]);
    }
}
